package com.dao.service;

import com.dao.model.Role;
import com.dao.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-06-02
 * Copyright  "Commercegate LTD"
 */
@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository repository;

    @Override
    public Role getRole(String name) {
        return repository.findByName(name);
    }
}
