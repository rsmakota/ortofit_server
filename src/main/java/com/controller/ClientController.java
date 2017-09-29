package com.controller;

import com.dao.model.Client;
import com.dao.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-09-29
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping(value = "/{msisdn}")
    public Client getClient(@PathVariable(value = "msisdn") String msisdn) {

        return service.findByMsisdn(msisdn);
    }


}
