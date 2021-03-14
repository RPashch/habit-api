package com.lyceum.habitapi.service;

import com.lyceum.habitapi.dao.HabitRepository;
import com.lyceum.habitapi.dao.UserRepository;
import com.lyceum.habitapi.models.Habit;
import com.lyceum.habitapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HabitService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private HabitRepository habitRepository;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public Habit addHabit(Habit habit, User user) {
        Habit persistedHabit = habitRepository.save(habit);

        jdbcTemplate.execute(
                String.format("insert into user_habit values ('%s', '%s')",
                        user.getId(),
                        persistedHabit.getId()
                )
        );

        return persistedHabit;
    }

    @Transactional
    public List<Habit> getUserHabits(User user){
        List<Habit> persistedHabit = userRepository.getUserHabits(user.getId());


        jdbcTemplate.execute(
                String.format("select h.id,h.title, h.description from user_habit u, habit h where u.habit_id = h.id and u.user_id = '%s'",
                        user.getId())
        );
        
        return persistedHabit;

    }


}
