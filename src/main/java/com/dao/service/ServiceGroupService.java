package com.dao.service;

import com.dao.model.ServiceGroup;
import com.dao.repository.ServiceGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-09-13
 * Copyright  "Commercegate LTD"
 */
@Service
public class ServiceGroupService implements IServiceGroupService {

    @Autowired
    private ServiceGroupRepository repository;

    @Override
    public ServiceGroup findByName(String name) {
        return repository.findByName(name);
    }
}
