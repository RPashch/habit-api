package com.lyceum.habitapi.service;

import com.lyceum.habitapi.dao.HabitRepository;
import com.lyceum.habitapi.dao.UserRepository;
import com.lyceum.habitapi.dto.HabitDto;
import com.lyceum.habitapi.entities.HabitEntity;
import com.lyceum.habitapi.models.Category;
import com.lyceum.habitapi.models.Habit;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HabitService {

    private JdbcTemplate jdbcTemplate;
    private HabitRepository habitRepository;
    private UserRepository userRepository;
    private CategoryService categoryService;


    @Transactional
    public void addHabit(Habit habit, String idUser) {
        habit.setCreatedAt(Instant.now());
        HabitEntity persistedHabit = habitRepository.save(createHabitEntity(habit));

        jdbcTemplate.execute(
                String.format("insert into user_habit values ('%s', '%s')",
                        idUser,
                        persistedHabit.getId()
                )
        );
    }

    public Habit getHabit(Long id) {
        return habitRepository
                .findById(id)
                .map(habitEntity -> createHabit(habitEntity))
                .orElse(null);
    }

    public List<Habit> getHabitsByUserId(Long userId) {

        List<HabitEntity> habitEntities = habitRepository.getUserHabits(userId);

        return habitEntities.stream()
                .map(habitEntity -> createHabit(habitEntity))
                .collect(Collectors.toList());


    }

    private Habit createHabit(HabitEntity habitEntity) {

        Category category = categoryService.getCategoryById(habitEntity.getCategoryId());

        return Habit.builder()
                .id(habitEntity.getId())
                .title(habitEntity.getTitle())
                .description(habitEntity.getDescription())
                .createdAt(habitEntity.getCreatedAt())
                .category(category)
                .build();
    }

    private HabitEntity createHabitEntity(Habit habit) {
        return HabitEntity.builder()
                .title(habit.getTitle())
                .createdAt(Instant.now())
                .description(habit.getDescription())
                .categoryId(habit.getCategory().getId())
                .build();
    }


}
