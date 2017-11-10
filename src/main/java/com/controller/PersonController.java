package com.controller;

import com.dao.model.Person;
import com.dao.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-17
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/person")
public class PersonController {
    @Autowired
    private PersonRepository repository;

    @GetMapping(value = "/client_id/{id}")
    public List<Person> findByClientId(@PathVariable(value = "id") Integer id) {
        return repository.findByClientId(id);
    }

    @PostMapping(value = "/")
    public Person postClient(@RequestBody Person person)
    {
        return repository.save(person);
    }

    @PutMapping(value = "/")
    public Person putClient(@RequestBody Person person)
    {
        return repository.save(person);
    }

}
