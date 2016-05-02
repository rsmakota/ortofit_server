package com.repository;

import com.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface CountryRepository  extends CrudRepository<Country, Long> {

    Page<Country> findAll(Pageable pageable);
}
