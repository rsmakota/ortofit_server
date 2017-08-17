package com.controller;

import com.dao.model.User;
import com.dao.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-14
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/doctor")
public class DoctorController {

    @Autowired
    private GroupService groupService;

    @GetMapping(value = "/")
    public Set<User> getAll() {
        return groupService.getGroup("Doctor").getUsers();
    }
}
