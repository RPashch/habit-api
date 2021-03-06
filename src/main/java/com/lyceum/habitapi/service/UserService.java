package com.lyceum.habitapi.service;

import com.lyceum.habitapi.dao.UserRepository;
import com.lyceum.habitapi.exceptions.UserNotFoundException;
import com.lyceum.habitapi.models.Habit;
import com.lyceum.habitapi.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

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
            throw new UserNotFoundException(
                    "user with id " + id + " not found"
            );
        }
        User persistedUser = persistedUserOpt.get();

        persistedUser.setFirstName(user.getFirstName());
        persistedUser.setLastName(user.getLastName());
        persistedUser.setUpdatedAt(Instant.now());
        persistedUser.setBirthDate(user.getBirthDate());

        return userRepository.save(persistedUser);
    }

    public List<Habit> getUserHabits(long userId) {
        return userRepository.getUserHabits(userId);
    }
}
