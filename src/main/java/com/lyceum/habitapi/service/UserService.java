package com.lyceum.habitapi.service;

import com.lyceum.habitapi.dao.UserRepository;
import com.lyceum.habitapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }
}