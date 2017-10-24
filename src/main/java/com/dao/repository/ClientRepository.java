package com.dao.repository;

import com.dao.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-09-29
 * Copyright  "Commercegate LTD"
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    public Client findByMsisdn(String msisdn);
}
