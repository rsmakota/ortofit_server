package com.dao.service;

import com.dao.model.Group;
import com.dao.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-14
 * Copyright  "Commercegate LTD"
 */
@Service
public class GroupService implements IGroupService{

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group getGroup(String name) {
        return groupRepository.findByName(name);
    }
    @Override
    public List<Group> findAll()
    {
        return groupRepository.findAll();
    }
}
