package com.controller;

import com.model.Appointment;
import com.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-05-16
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping(value = "/")
    public Appointment getAppointment(@RequestParam(value = "id") Integer id) {
        return service.find(id);
    }

    @PostMapping("/")
    public void postAppointment(@RequestBody Appointment appointment) {

        service.create(appointment);

    }

}
