package com.controller;

import com.dao.model.Diagnosis;
import com.dao.repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-17
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/diagnosis")
public class DiagnosisController {
    @Autowired
    private DiagnosisRepository repository;

    @GetMapping(value = "/person/{id}")
    public List<Diagnosis> getByPersonId(@PathVariable(value = "id") Integer id) {
        return repository.findByPersonId(id);
    }

    @PostMapping(value = "/")
    public Diagnosis crate(@RequestBody Diagnosis diagnosis) {
        return repository.save(diagnosis);
    }

    @PutMapping(value = "/")
    public Diagnosis update(@RequestBody Diagnosis diagnosis) {
        return repository.save(diagnosis);
    }


}
