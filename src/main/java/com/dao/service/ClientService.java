package com.dao.service;

import com.dao.model.Client;
import com.dao.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-09-29
 * Copyright  "Commercegate LTD"
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client findByMsisdn(String msisdn)
    {
        return repository.findByMsisdn(msisdn);
    }
}
