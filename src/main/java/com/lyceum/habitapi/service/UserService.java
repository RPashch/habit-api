package com.lyceum.habitapi.service;

import com.lyceum.habitapi.dao.UserRepository;
import com.lyceum.habitapi.models.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    public User updateUserData(User user, long id) {
        Optional<User> persistedUserOpt = userRepository.findById(id);

        if (persistedUserOpt.isEmpty()) {
            throw UserNotFoundException(
                    "user with id " + id + " not found"
            )
        }
        User persistedUser = persistedUserOpt.get();

        persistedUser.setFirstName(user.getFirstName());
        persistedUser.setLastName(user.getLastName());
        persistedUser.setUpdatedAt(Instant.now());
        persistedUser.setBirthDate(user.getBirthDate());

        return userRepository.save(persistedUser);
    }
}
