package com.lyceum.habitapi.dao;

import com.lyceum.habitapi.models.Habit;
import com.lyceum.habitapi.models.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT * from public.user where user_name=:userName")
    List<User> findByUserName(@Param("userName") String userName);

    @Query("select h.id,h.title, h.description from user_habit u, habit h where u.habit_id = h.id and u.user_id =:userId")
    List<Habit> getUserHabits(@Param("userId") long userId);

}
