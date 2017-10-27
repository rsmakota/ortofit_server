package com.dao.service;

import com.dao.model.Client;
import com.dao.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-09-29
 * Copyright  "Commercegate LTD"
 */
@Service
@Transactional
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public Client findByMsisdn(String msisdn)
    {
        return repository.findByMsisdn(msisdn);
    }

    public Client save(Client client) {
        return repository.save(client);
    }

    public Client findById(Integer id) {
        return repository.findOne(id);
    }

    public Page<Client> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    public Page<Client> findAllByMsisdnContaining(String msisdn, Pageable pageable) {
        return repository.findAllByMsisdnContaining(msisdn, pageable);
    }

}
