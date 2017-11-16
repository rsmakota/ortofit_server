package com.controller;

import com.dao.report.AppointmentReport;
import com.dao.service.AppointmentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-05-16
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/appointment_report")
public class AppointmentReportController {

    @Autowired
    private AppointmentReportService service;

    @GetMapping(value = "/client/{id}")
    public List<AppointmentReport> getAppointmentReportByClientId(@PathVariable(value = "id") Integer client_id) {

        return service.findByClientId(client_id);
    }

}
