package com.controller;

import com.dao.model.Diagnosis;
import com.dao.model.Insole;
import com.dao.repository.DiagnosisRepository;
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

    @GetMapping(value = "/person/{id}")
    public List<Insole> getByPersonId(@PathVariable(value = "id") Integer id) {
        return repository.findByPersonId(id);
    }

    @PostMapping(value = "/")
    public Insole crate(@RequestBody Insole insole) {
        return repository.save(insole);
    }

    @PutMapping(value = "/")
    public Insole update(@RequestBody Insole insole) {
        return repository.save(insole);
    }


}
