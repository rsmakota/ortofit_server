package com.controller;

import com.dao.model.Appointment;
import com.dao.model.CalendarEvent;
import com.dao.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-10
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @GetMapping(value = "/")
    public List<CalendarEvent> getAppointment(
            @RequestParam(value = "start") String start,
            @RequestParam(value = "end") String end,
            @RequestParam(value = "officeId") Integer officeId
    ) {
        String from = start + " 00:00:00";
        String to   = end + " 00:00:00";
        Timestamp timestampFrom;
        Timestamp timestampTo;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date parsedDateFrom = dateFormat.parse(from);
            Date parsedDateTo = dateFormat.parse(to);

            timestampFrom = new java.sql.Timestamp(parsedDateFrom.getTime());
            timestampTo = new java.sql.Timestamp(parsedDateTo.getTime());

        } catch(Exception e) { //this generic but you can control another types of exception
            timestampFrom = new Timestamp(System.currentTimeMillis() - 100000);
            timestampTo = new Timestamp(System.currentTimeMillis());
        }
        return service.find(timestampFrom, timestampTo, officeId,1);
    }
}
