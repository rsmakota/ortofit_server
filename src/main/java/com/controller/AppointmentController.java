package com.controller;

import com.dao.model.Appointment;
import com.dao.model.FullAppointmentData;
import com.dao.service.AppointmentService;
import com.dao.type.AppointmentState;
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

    private final AppointmentService service;

    @Autowired
    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public FullAppointmentData getAppointment(@PathVariable(value = "id") Integer id) {

        return service.findFull(id);
    }

    @GetMapping(value = "/client/last/{clientId}")
    public Appointment getLastSuccessByClientId(@PathVariable(value = "clientId") Integer clientId) {

        return service.findLastByClientId(clientId, AppointmentState.Success.ordinal());
    }

    @PostMapping("/")
    public Integer postAppointment(@RequestBody Appointment appointment) {
        appointment.setState(AppointmentState.New.ordinal());
        service.create(appointment);
        return appointment.getId();
    }

    @PutMapping("/")
    public Integer putAppointment(@RequestBody Appointment appointment) {
        service.update(appointment);
        return appointment.getId();
    }
}
