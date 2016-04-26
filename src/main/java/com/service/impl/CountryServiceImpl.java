package com.service.impl;


import com.dao.intf.CountryDao;
import com.entity.Country;
import com.service.intf.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("storageService")
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao dao;

    @Transactional
    @Override
    public void save(Country country) {
        dao.save(country);
    }

    @Override
    public List<Country> getAll() {
        return dao.getAll();
    }
}
