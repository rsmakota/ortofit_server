package com.dao.repository;

import com.dao.model.ServiceGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-09-13
 * Copyright  "Commercegate LTD"
 */
@Repository
public interface ServiceGroupRepository extends JpaRepository<ServiceGroup, Integer> {
    public ServiceGroup findByName(String name);
}
