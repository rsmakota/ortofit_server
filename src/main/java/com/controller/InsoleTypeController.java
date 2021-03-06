package com.controller;

import com.dao.model.InsoleType;
import com.dao.model.Office;
import com.dao.repository.InsoleTypeRepository;
import com.dao.service.IOfficeService;
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
@RequestMapping(value = "/api/insole_type")
public class InsoleTypeController {
    @Autowired
    private InsoleTypeRepository repository;

    @GetMapping(value = "/")
    public List<InsoleType> getAll() {
        return repository.findAll();
    }

}
