package com.service;

import com.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-05-26
 * Copyright  "Commercegate LTD"
 */
public interface IUserService {

    public void save(User user);
    public PasswordEncoder getPasswordEncoder();
}
