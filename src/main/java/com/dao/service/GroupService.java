package com.dao.service;

import com.dao.model.Group;
import com.dao.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-14
 * Copyright  "Commercegate LTD"
 */
@Service
public class GroupService implements IGroupService{

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group getGroup(String name) {
        return groupRepository.findByName(name);
    }
}
