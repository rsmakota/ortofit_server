package com.controller;

import com.dao.model.PersonService;
import com.dao.repository.PersonServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-17
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/person_service")
public class PersonServiceController {
    @Autowired
    private PersonServiceRepository repository;

    @GetMapping(value = "/person/{id}")
    public List<PersonService> getByPersonId(@PathVariable(value = "id") Integer id) {
        return repository.findByPersonId(id);
    }
    @GetMapping(value = "/appointment/{id}")
    public List<PersonService> getByAppId(@PathVariable(value = "id") Integer id) {
        return repository.findByAppointmentId(id);
    }

    @PostMapping(value = "/")
    public PersonService crate(@RequestBody PersonService personService) {
        return repository.save(personService);
    }


}
