package com.lyceum.habitapi.dao;

import com.lyceum.habitapi.dto.HabitDto;
import com.lyceum.habitapi.entities.HabitEntity;
import com.lyceum.habitapi.models.Habit;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitRepository extends CrudRepository<HabitEntity, Long> {

    List<HabitEntity> getAllByIdIn(List<Long> habitIds);

    @Query("select h.* from habit h where h.id in (select habit_id from user_habit where user_id =:userId)")
    List<HabitEntity> getUserHabits(@Param("userId") long userId);

}
