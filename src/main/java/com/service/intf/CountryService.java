package com.service.intf;


import com.entity.Country;

import java.util.List;

public interface CountryService {
    public void save(Country country);
    public List<Country> getAll();
}
