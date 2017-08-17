package com.controller;

import com.dao.model.Role;
import com.dao.model.User;
import com.pojos.UserRegistration;
import com.dao.service.RoleService;
import com.dao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-06-02
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/")
    public String register(@RequestBody UserRegistration userRegistration) {
        if(!userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation())) {
            return "Passwords do not match";
        } else if (userService.getUser(userRegistration.getUsername()) != null) {
            return "User already exist";
        }
        Role role = roleService.getRole("ROLE_CLIENT");
        // input sanitization
        User user = new User();
        user.setUsername(userRegistration.getUsername());
        user.setName(userRegistration.getUsername());
        user.setUsernameCanonical(userRegistration.getUsername());
        user.setEmail(userRegistration.getEmail());
        user.setEmailCanonical(userRegistration.getEmail());
        user.setPassword(userRegistration.getPassword());
//        user.setRoles(Arrays.asList(role));
        user.setSalt("");

        userService.save(user);

        return "user created";
    }
    @GetMapping(value = "/{id}")
    public User find(@PathVariable(value = "id") Integer id) {
        return userService.find(id);
    }

    @GetMapping(value = "/all")
    public List<User> all() {
        return userService.all();
    }

}
