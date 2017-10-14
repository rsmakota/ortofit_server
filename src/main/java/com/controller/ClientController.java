package com.controller;

import com.dao.model.Client;
import com.dao.model.Country;
import com.dao.repository.CountryRepository;
import com.dao.service.ClientService;
import com.requestWrapper.ClientWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping(value = "/msisdn/{msisdn}")
    public Client getClient(@PathVariable(value = "msisdn") String msisdn) {

        return service.findByMsisdn(msisdn);
    }

    @GetMapping(value = "/id/{id}")
    public Client getClient(@PathVariable(value = "id") Integer id) {

        return service.findById(id);
    }

    @PostMapping(value = "/")
    public Client postClient(@RequestBody Client client)
    {
        return service.save(client);
    }

    @PutMapping(value = "/")
    public Client putClient(@RequestBody Client client)
    {
        if (client.getCountryId() == null) {
            client.setCountryId(1);
        }
        return service.save(client);
    }


}
