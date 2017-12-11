package com.controller;

import com.dao.model.User;
import com.dao.service.StaffScheduleService;
import com.dao.service.UserService;
import com.response.model.ICalendarEvent;
import com.dao.model.Schedule;
import com.dao.repository.StaffScheduleRepository;
import com.response.wrapper.StaffScheduleWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-10
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/staff_schedule")
public class StaffScheduleController {

    @Autowired
    private StaffScheduleService service;
    @Autowired
    private UserService userService;
    @GetMapping(value = "/")
    public List<ICalendarEvent> getAppointment(
            @RequestParam(value = "start") String start,
            @RequestParam(value = "end") String end,
            @RequestParam(value = "officeId") Integer officeId,
            @RequestParam(value = "doctorId", required = false) Integer doctorId
    ) {
        String from = start + " 00:00:00";
        String to   = end + " 00:00:00";
        Timestamp timestampFrom;
        Timestamp timestampTo;
        User doctor = (doctorId != null) ? userService.find(doctorId) : null;

        List<ICalendarEvent> allEvents = new ArrayList<>();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date parsedDateFrom         = dateFormat.parse(from);
            Date parsedDateTo           = dateFormat.parse(to);

            timestampFrom = new Timestamp(parsedDateFrom.getTime());
            timestampTo   = new Timestamp(parsedDateTo.getTime());

        } catch(Exception e) { //this generic but you can control another types of exception
            timestampFrom = new Timestamp(System.currentTimeMillis() - 100000);
            timestampTo = new Timestamp(System.currentTimeMillis());
        }
        List<Schedule> schedules = service.findByRange(timestampFrom, timestampTo, officeId, doctorId);

        for (Schedule schedule: schedules) {
            if (doctorId == null) {
                doctor = userService.find(schedule.getUserId());
            }
            allEvents.add(new StaffScheduleWrapper(schedule, doctor));
        }
        return allEvents;
    }
}
