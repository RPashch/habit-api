package com.lyceum.habitapi.service;

import com.lyceum.habitapi.dao.HabitRepository;
import com.lyceum.habitapi.exceptions.HabitNotFoundException;
import com.lyceum.habitapi.models.Habit;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.time.Instant;

@Service
@AllArgsConstructor
public class HabitService {

    private JdbcTemplate jdbcTemplate;
    private HabitRepository habitRepository;

    @Transactional
    public void addHabit(Habit habit, String idUser) {
        habit.setCreatedAt(Instant.now());
        Habit persistedHabit = habitRepository.save(habit);

        jdbcTemplate.execute(
                String.format("insert into user_habit values ('%s', '%s')",
                        idUser,
                        persistedHabit.getId()
                )
        );


    }

    public Habit findById(long habitId) {
        return habitRepository
                .findById(habitId)
                .orElseThrow(() -> new HabitNotFoundException(
                        "habit with id " + habitId + " not found!"));
    }

    public ArrayList<Habit> getUserHabits(long userId) {
        return userRepository.getUserHabits(userId);
    }


}