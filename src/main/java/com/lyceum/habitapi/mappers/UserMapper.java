package com.lyceum.habitapi.mappers;

import com.lyceum.habitapi.dto.UserDto;
import com.lyceum.habitapi.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {

    public static UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    public abstract User userToUserDto(UserDto userDto);

    public abstract UserDto userDtoToUser(User user);

//    public abstract Iterable<UserDto> usersToUserDtos

}
