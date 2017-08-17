package com.dao.service;

import com.dao.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-05-26
 * Copyright  "Commercegate LTD"
 */
public interface IUserService {

    public void save(User user);
    public PasswordEncoder getPasswordEncoder();
    User getUser(String username);

    List<User> all();
    public User find(Integer id);

}
