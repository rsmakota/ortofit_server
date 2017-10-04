package com.dao.repository;

import com.dao.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-10-03
 * Copyright  "Commercegate LTD"
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    public Country findById(Integer id);
}
