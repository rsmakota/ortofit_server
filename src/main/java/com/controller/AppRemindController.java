package com.controller;

import com.dao.model.AppRemind;
import com.dao.repository.AppRemindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-05-16
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/remind")
public class AppRemindController {

    @Autowired
    private AppRemindRepository repository;

    @GetMapping(value = "/id/{id}")
    public AppRemind getAppRemind(@PathVariable(value = "id") Integer id) {
        return repository.findOne(id);
    }

    @GetMapping(value = "/appointment/{appointmentId}/person/{personId}")
    public List<AppRemind> getAppRemindByAppAndPeron(
            @PathVariable(value = "appointmentId") Integer appointmentId,
            @PathVariable(value = "personId") Integer personId) {
        return repository.findByAppointmentIdAndPersonId(appointmentId, personId);
    }

    @PostMapping("/")
    public AppRemind postAppRemind(@RequestBody AppRemind appRemind) {
        return repository.save(appRemind);
    }

    @PutMapping("/")
    public AppRemind putAppRemind(@RequestBody AppRemind appRemind) {
        return repository.save(appRemind);
    }
}
