package com.controller;

import com.dao.model.Group;
import com.dao.model.Role;
import com.dao.model.User;
import com.pojos.UserRegistration;
import com.dao.service.RoleService;
import com.dao.service.UserService;
import com.request.UserEmail;
import com.request.UserPassword;
import com.response.FailResponse;
import com.response.IResponse;
import com.response.SuccessResponse;
import org.apache.coyote.Response;
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

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

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
    public List<User> all(Principal principal) throws Exception {
        User user = userService.getUser(principal.getName());

        if (!isAdmin(user.getGroups())) {
            throw new Exception("You can't get user's list");
        }

        return userService.findAllActive();
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
    public IResponse changePassword(@RequestBody UserPassword userPassword, Principal principal) {
        try {
            User user = userService.find(userPassword.getId());

            if (null == user) {
                throw new Exception("Undefined user");
            }

            Set<Group> groups = user.getGroups();
            if (!principal.getName().equals(user.getUsername()) && !isAdmin(groups)) {
                throw new Exception("You can't change others password");
            }

            if(userPassword.getPassword().length() < 6) {
                throw new Exception("Password is too short");
            }

            if (!userPassword.getPassword().equals(userPassword.getPasswordConfirmation())) {
                throw new Exception("Password and confirmation are not equal");
            }

            String password = userService.getPasswordEncoder().encode(userPassword.getPassword());
            user.setPassword(password);
            userService.save(user);

            return new SuccessResponse();
        } catch (Exception e) {
            return new FailResponse(0, e.getMessage());
        }
    }

    @PutMapping(value = "/change_email")
    public IResponse changeEmail(@RequestBody UserEmail userEmail, Principal principal) {
        try {
            User user = userService.find(userEmail.getId());
            if (null == user) {
                throw new Exception("Undefined user");
            }
            Set<Group> groups = user.getGroups();
            if (!principal.getName().equals(user.getUsername()) && !isAdmin(groups)) {
                throw new Exception("You can't change others email");
            }
            user.setEmail(userEmail.getEmail());
            userService.save(user);

            return new SuccessResponse();
        } catch (Exception e) {
            return new FailResponse(0, e.getMessage());
        }
    }
    @DeleteMapping(value = "/")
    public void delete(@RequestBody Integer userId, Principal principal) throws Exception {
        User curUser = userService.getUser(principal.getName());

        if (!isAdmin(curUser.getGroups())) {
            throw new Exception("You can't delete a user");
        }

        User user = userService.find(userId);
        if (null == user) {
            throw new Exception("Can't find user with id " + userId);
        }

        userService.delete(user);

    }

    private Boolean isAdmin(Set<Group> groups) {
        for (Group group: groups) {
            if (group.getName().equals("Admin")) {
                return true;
            }
        }

        return false;
    }

}
