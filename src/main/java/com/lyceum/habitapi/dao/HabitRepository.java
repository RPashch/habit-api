package com.lyceum.habitapi.dao;

import com.lyceum.habitapi.models.Habit;
import com.lyceum.habitapi.models.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitRepository extends CrudRepository<Habit, Long> {
    @Query("SELECT * from public.habit where id=:habitId")
    List<Habit> findByHabitId(@Param("habitId") long habitId);
//    @Query("SELECT * from public.habit where Category_id=:CatId")
//    List<Habit> findByCategoryId(@Param("CatId") long CatId);

}

