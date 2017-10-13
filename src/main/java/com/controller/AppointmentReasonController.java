package com.controller;

import com.dao.model.AppointmentReason;
import com.dao.repository.AppointmentReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-05-16
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/appointment_reason")
public class AppointmentReasonController {

    @Autowired
    private AppointmentReasonRepository repository;

    @GetMapping(value = "/id/{id}")
    public AppointmentReason getReason(@PathVariable(value = "id") Integer id) {
        return repository.findOne(id);
    }

    @GetMapping(value = "/appointment/{id}")
    public List<AppointmentReason> getReasons(@PathVariable(value = "id") Integer id) {
        return repository.findByAppointmentId(id);
    }

    @PostMapping("/")
    public Integer postAppointment(@RequestBody AppointmentReason reason) {
        repository.save(reason);
        return reason.getId();
    }

}
