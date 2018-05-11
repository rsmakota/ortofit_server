package com.controller;

import com.dao.model.Group;

import com.dao.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2018-05-10
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/group")
public class GroupsController {

    private final IGroupService service;

    @Autowired
    public GroupsController(IGroupService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public List<Group> getAll() {
        return service.findAll();
    }
}
