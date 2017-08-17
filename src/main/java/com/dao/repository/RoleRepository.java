package com.dao.repository;

import com.dao.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-06-02
 * Copyright  "Commercegate LTD"
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    public Role findByName(String name);
}
