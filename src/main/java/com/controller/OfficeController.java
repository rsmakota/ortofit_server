package com.controller;

import com.dao.model.Office;
import com.dao.service.IOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-17
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/office")
public class OfficeController {
    @Autowired
    private IOfficeService officeService;

    @GetMapping(value = "/{id}")
    public Office get(@PathVariable(value = "id") Integer id) {

        return officeService.find(id);
    }

    @GetMapping(value = "/all")
    public List<Office> getAll() {
        return officeService.findAll();
    }

}
