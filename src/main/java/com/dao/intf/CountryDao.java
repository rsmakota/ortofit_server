package com.dao.intf;

import com.entity.Country;
import java.util.List;


public interface CountryDao {
    public void save(Country content);
    public List<Country> getAll();
}
