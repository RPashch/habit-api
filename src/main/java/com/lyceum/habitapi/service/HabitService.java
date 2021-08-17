package com.lyceum.habitapi.service;

import com.lyceum.habitapi.dao.HabitRepository;
import com.lyceum.habitapi.dao.UserRepository;
import com.lyceum.habitapi.models.Habit;
import com.lyceum.habitapi.models.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@AllArgsConstructor
public class HabitService {

    private JdbcTemplate jdbcTemplate;
    private HabitRepository habitRepository;
    private UserRepository userRepository;


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


}
