package com.controller;

import com.dao.model.FamilyStatus;
import com.dao.repository.FamilyStatusRepository;
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
@RequestMapping(value = "/api/family_status")
public class FamilyStatusController {
    @Autowired
    private FamilyStatusRepository repository;

    @GetMapping(value = "/")
    public List<FamilyStatus> getAll() {
        return repository.findAll();
    }

}
