package com.dao.repository;

import com.dao.model.InsoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-17
 * Copyright  "Commercegate LTD"
 */
@Repository
public interface InsoleTypeRepository extends JpaRepository<InsoleType, Integer> {
}
