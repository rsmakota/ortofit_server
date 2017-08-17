package com.dao.repository;

import com.dao.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-14
 * Copyright  "Commercegate LTD"
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    public Group findByName(String name);
}
