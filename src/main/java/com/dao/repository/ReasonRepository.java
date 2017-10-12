package com.dao.repository;

import com.dao.model.Reason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-17
 * Copyright  "Commercegate LTD"
 */
@Repository
public interface ReasonRepository extends JpaRepository<Reason, Integer> {
}
