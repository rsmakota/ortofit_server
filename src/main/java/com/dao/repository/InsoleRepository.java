package com.dao.repository;

import com.dao.model.Insole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-17
 * Copyright  "Commercegate LTD"
 */
@Repository
public interface InsoleRepository extends JpaRepository<Insole, Integer> {
    List<Insole> findByPersonId(Integer id);
}
