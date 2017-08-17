package com.dao.service;

import com.dao.model.Group;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-14
 * Copyright  "Commercegate LTD"
 */
interface IGroupService {
    public Group getGroup(String name);
}
