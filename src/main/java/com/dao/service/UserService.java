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

    private final UserRepository repo;

    private final PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

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

    @Override
    public void delete(User user) {
        user.setGroups(null);
        user.setEnabled(false);

        repo.save(user);
    }

    public List<User> findAllActive()
    {
        return repo.findByEnabledTrue();
    }
}