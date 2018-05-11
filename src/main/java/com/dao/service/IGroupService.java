package com.dao.service;

import com.dao.model.Group;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-14
 * Copyright  "Commercegate LTD"
 */
public interface IGroupService {
    public Group getGroup(String name);

    public List<Group> findAll();
}
