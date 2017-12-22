package com.controller;

import com.dao.model.ClientDirection;
import com.dao.model.Office;
import com.dao.repository.AppointmentRepository;
import com.dao.repository.ClientDirectionsRepository;
import com.dao.repository.ClientRepository;
import com.dao.repository.OfficeRepository;
import com.dao.type.AppointmentState;
import com.response.model.LineChartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-02
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/chart")
public class ChartController {
    @Autowired
    private ClientDirectionsRepository directionsRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OfficeRepository officeRepository;
    @Autowired
    private AppointmentRepository appRepository;

    @GetMapping(value="/new_client_by_directions")
    public List<LineChartItem> newClientsByDirections (
            @RequestParam(value = "start") String start,
            @RequestParam(value = "end") String end
    ) throws Exception {
        List <MonthDate> months = getListMonths(start, end);
        List<ClientDirection> directions = directionsRepository.findAllByOrderByOrderNum();

        List<LineChartItem> result = new ArrayList<>();
        for (ClientDirection direction: directions) {
            LineChartItem item = new LineChartItem();
            item.setName(direction.getName());
            List<Integer> data = new ArrayList<>();
            for (MonthDate mDate: months) {
                Integer val = clientRepository.countClientByClientDirectionIdAndCreatedBetween(direction.getId(), mDate.firstDay, mDate.lastDate);
                data.add(val);
            }
            item.setData(data);
            result.add(item);
        }

        return result;
    }
    @GetMapping(value="/success_app_by_offices")
    public List<LineChartItem> successAppByOffices(
            @RequestParam(value = "start") String start,
            @RequestParam(value = "end") String end
    )throws Exception {
        List <MonthDate> months = getListMonths(start, end);
        List<Office> offices = officeRepository.findAll();
        List<LineChartItem> result = new ArrayList<>();
        for (Office office: offices) {
            LineChartItem item = new LineChartItem();
            item.setName(office.getName());
            List<Integer> data = new ArrayList<>();
            for (MonthDate mDate : months) {
                Integer val = appRepository.countAppointmentByOfficeIdAndDateTimeBetweenAndState(office.getId(), mDate.firstDay, mDate.lastDate, AppointmentState.Success.ordinal());
                data.add(val);
            }
            item.setData(data);
            result.add(item);
        }

        return result;
    }

    private List<MonthDate> getListMonths(String from, String to)throws Exception
    {
        DateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date toDate = dateFormat.parse(to + " 23:59:59");
        List<MonthDate> list = new ArrayList<>();
        MonthDate item = new MonthDate(from);
        Calendar cal = Calendar.getInstance();

        cal.setTime(item.getFirstDay());
        while (item.lastDate.before(toDate)) {
            list.add(item);
            cal.setTime(item.getFirstDay());
            cal.add(Calendar.MONTH, 1);
            item = new MonthDate(cal.getTime());
        }

        return list;
    }

    final private class MonthDate {
        DateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        private Date firstDay;
        private Date lastDate;

        public MonthDate(String firstDay) {
            try {
                this.firstDay = dateFormat.parse(firstDay + " 00:00:00");
                Calendar cal = Calendar.getInstance();
                cal.setTime(this.firstDay);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                this.firstDay = cal.getTime();
                cal.setTime(this.firstDay);
                cal.add(Calendar.MONTH, 1);
                cal.set(Calendar.SECOND, -1);
                lastDate = cal.getTime();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        public MonthDate(Date firstDay) {
            try {
                this.firstDay = firstDay;
                Calendar cal = Calendar.getInstance();
                cal.setTime(this.firstDay);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                this.firstDay = cal.getTime();
                cal.setTime(this.firstDay);
                cal.add(Calendar.MONTH, 1);
                cal.set(Calendar.SECOND, -1);
                lastDate = cal.getTime();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        public Date getFirstDay() {
            return firstDay;
        }

        public Date getLastDate() {
            return lastDate;
        }
    }
}
