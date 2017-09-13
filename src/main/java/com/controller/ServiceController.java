package com.controller;

import com.dao.model.Service;
import com.dao.service.ServiceGroupService;
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
@RequestMapping(value = "/api/service")
public class ServiceController {

    @Autowired
    private ServiceGroupService service;

    @GetMapping(value = "/")
    public Set<Service> getAll() {
        Set<Service> services = service.findByName("base").getServices();
        services.addAll(service.findByName("base_massage").getServices());

        return services;
    }
}
