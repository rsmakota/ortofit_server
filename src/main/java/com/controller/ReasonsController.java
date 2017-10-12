package com.controller;

import com.dao.model.Reason;
import com.dao.repository.ReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-17
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/reason")
public class ReasonsController {
    @Autowired
    private ReasonRepository repository;

    @GetMapping(value = "/")
    public List<Reason> getAll() {
        return repository.findAll();
    }
}
