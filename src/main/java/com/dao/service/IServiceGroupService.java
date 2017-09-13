package com.dao.service;

import com.dao.model.ServiceGroup;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-09-13
 * Copyright  "Commercegate LTD"
 */
public interface IServiceGroupService {
    public ServiceGroup findByName(String name);
}
