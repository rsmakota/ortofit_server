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
    @GetMapping(value = "/{msisdn}")
    public Client getClient(@PathVariable(value = "msisdn") String msisdn) {

        return service.findByMsisdn(msisdn);
    }

    @PostMapping(value = "/")
    public Client postClient(@RequestBody ClientWrapper wrapper)
    {
        Country country = countryRepository.findById(wrapper.getCountryId());
        Client client = new Client();
        client.setCountry(country);
        client.setMsisdn(wrapper.getMsisdn());
        client.setGender(wrapper.getGender());
        client.setName(wrapper.getName());

        return service.save(client);
    }

}
