package com.service;

import com.model.Country;

import java.util.List;

public interface CountryService {

    Country addCountry(Country Country);
    void delete(long id);
    Country editCountry(Country Country);
    List<Country> getAll();

}
