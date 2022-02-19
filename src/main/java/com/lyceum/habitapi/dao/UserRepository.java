package com.lyceum.habitapi.dao;

import com.lyceum.habitapi.dto.UserDto;
import com.lyceum.habitapi.entities.UserEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query("SELECT * from public.user where user_name=:userName")
    List<UserEntity> findByUserName(@Param("userName") String userName);

}
