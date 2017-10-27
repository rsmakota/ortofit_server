package com.dao.repository;

import com.dao.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-09-29
 * Copyright  "Commercegate LTD"
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    public Client findByMsisdn(String msisdn);

    public Page<Client> findAllByMsisdnContaining(String msisdn, Pageable pageable);
}
