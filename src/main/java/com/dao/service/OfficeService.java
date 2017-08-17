package com.dao.service;

import com.dao.model.Office;
import com.dao.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-17
 * Copyright  "Commercegate LTD"
 */
@Service
public class OfficeService implements IOfficeService {
    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public Office find(Integer id) {
        return officeRepository.findOne(id);
    }

    @Override
    public List<Office> findAll() {
        return officeRepository.findAll();
    }
}
