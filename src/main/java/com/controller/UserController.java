package com.controller;

import com.dao.model.Group;
import com.dao.model.Role;
import com.dao.model.User;
import com.pojos.UserRegistration;
import com.dao.service.RoleService;
import com.dao.service.UserService;
import com.request.UserEmail;
import com.request.UserPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.beans.Expression;
import java.security.Principal;
import java.util.List;
import java.util.Set;

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

    @PostMapping(value = "/")
    public String register(@RequestBody UserRegistration userRegistration) {
        if(!userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation())) {
            return "Passwords do not match";
        } else if (userService.getUser(userRegistration.getUsername()) != null) {
            return "User already exist";
        }

        String password = userService.getPasswordEncoder().encode(userRegistration.getPassword());
        User user = new User();
        user.setUsername(userRegistration.getUsername());
        user.setName(userRegistration.getUsername());
        user.setUsernameCanonical(userRegistration.getUsername());
        user.setEmail(userRegistration.getEmail());
        user.setEmailCanonical(userRegistration.getEmail());
        user.setPassword(password);
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
    @GetMapping(value = "/")
    public User current(Principal principal) {
        return userService.getUser(principal.getName());
    }

    @GetMapping(value = "/group")
    public Set<Group> currentGroups(Principal principal) {
        return userService.getUser(principal.getName()).getGroups();
    }

    @PutMapping(value = "/change_password")
    public User changePassword(@RequestBody UserPassword userPassword) throws Exception {
        User user = userService.find(userPassword.getId());
        if (null == user || !userPassword.getPassword().equals(userPassword.getPasswordConfirmation())) {
            throw new Exception("Undefined user or password");
        }
        String password = userService.getPasswordEncoder().encode(userPassword.getPassword());
        user.setPassword(password);
        userService.save(user);

        return user;
    }

    @PutMapping(value = "/change_email")
    public User changeEmail(@RequestBody UserEmail userEmail) throws Exception {
        User user = userService.find(userEmail.getId());
        user.setPassword(userEmail.getEmail());
        userService.save(user);

        return user;
    }



}
