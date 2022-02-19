package com.lyceum.habitapi.service;

import com.lyceum.habitapi.dao.CategoryRepository;
import com.lyceum.habitapi.dao.HabitRepository;
import com.lyceum.habitapi.dao.UserRepository;
import com.lyceum.habitapi.dto.UserDto;
import com.lyceum.habitapi.entities.UserEntity;
import com.lyceum.habitapi.mappers.UserMapper;
import com.lyceum.habitapi.models.Habit;
import com.lyceum.habitapi.models.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private HabitService habitService;
    private CategoryRepository categoryRepository;

    public void addUser(User user) {
        userRepository.save(createUserEntity(user));
    }

    public List<User> getUsersByName(String name) {
        List<UserEntity> userEntities = userRepository.findByUserName(name);

        return userEntities.stream()
                .map(this::createUser)
                .collect(Collectors.toList());

    }

    private UserEntity createUserEntity(User user) {
        return UserEntity.builder()
                .userName(user.getUserName())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthDate(user.getBirthDate())
                .createdAt(Instant.now())
                .build();
    }

    private User createUser(UserEntity userEntity) {
        List<Habit> habits = habitService.getHabitsByUserId(userEntity.getId());

        return User.builder()
                .id(userEntity.getId())
                .userName(userEntity.getUserName())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .birthDate(userEntity.getBirthDate())
                .createdAt(Instant.now())
                .habits(habits)
                .build();
    }
}
