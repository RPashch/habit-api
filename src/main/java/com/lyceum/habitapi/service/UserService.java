package com.lyceum.habitapi.service;

import com.lyceum.habitapi.dao.UserRepository;
import com.lyceum.habitapi.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User addUser(User user) {
        user.setCreatedAt(Instant.now());
        return userRepository.save(user);
    }
}
