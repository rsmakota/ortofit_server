package com.controller;

import com.dao.model.Insole;
import com.dao.repository.InsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-17
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/insole")
public class InsoleController {
    @Autowired
    private InsoleRepository repository;

    @GetMapping(value = "/appointment/{appId}/person/{personId}")
    public List<Insole> getByAppIdAndPersonId(@PathVariable(value = "appId") Integer appId, @PathVariable(value = "personId") Integer personId) {
        return repository.findByAppointmentIdAndPersonId(appId, personId);
    }

    @PostMapping(value = "/")
    public Insole crate(@RequestBody Insole insole) {
        return repository.save(insole);
    }

    @PutMapping(value = "/")
    public Insole update(@RequestBody Insole insole) {
        return repository.save(insole);
    }

    @PostMapping(value = "/group")
    public void createGroup(@RequestBody List<Insole> insoles) {
        if (insoles.size() < 1) {
            return;
        }
        Integer appId = insoles.get(0).getAppointmentId();
        Integer personId = insoles.get(0).getPersonId();
        repository.deleteAllByAppointmentIdAndPersonId(appId, personId);
        repository.save(insoles);
    }
}
