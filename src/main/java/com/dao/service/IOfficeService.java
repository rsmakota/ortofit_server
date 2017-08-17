package com.dao.service;

import com.dao.model.Office;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-17
 * Copyright  "Commercegate LTD"
 */
public interface IOfficeService {

    public Office find(Integer id);

    public List<Office> findAll();
}
