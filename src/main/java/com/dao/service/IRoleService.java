package com.dao.service;

import com.dao.model.Role;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-06-02
 * Copyright  "Commercegate LTD"
 */
public interface IRoleService {
    public Role getRole(String name);
}
