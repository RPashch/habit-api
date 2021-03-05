package com.lyceum.habitapi.dao;

import com.lyceum.habitapi.models.Habit;
import com.lyceum.habitapi.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends CrudRepository<Habit, Long> {
}
