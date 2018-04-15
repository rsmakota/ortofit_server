package com.dao.service;

import com.dao.model.User;
import com.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    public PasswordEncoder getPasswordEncoder() {
        return encoder;
    }

    public void save(User user) {
        repo.save(user);
    }

    public User getUser(String username) {
        return repo.findByUsername(username);
    }

    public List<User> all()
    {
        return repo.findAll();
    }

    public User find(Integer id) {
        return repo.findById(id);
    }

}