package com.dao.repository;

import com.dao.model.ClientDirection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-09-29
 * Copyright  "Commercegate LTD"
 */
@Repository
public interface ClientDirectionsRepository extends JpaRepository<ClientDirection, Integer> {
    public List<ClientDirection> findAllByOrderByOrderNum();
}
