package com.lyceum.habitapi.dao;

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
}
