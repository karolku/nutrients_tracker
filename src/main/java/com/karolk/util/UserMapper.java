package com.karolk.util;

import com.karolk.dto.UserDto;
import com.karolk.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto convertEntityUserToUserDto(User user);

    User convertUserDtoToEntityUser(UserDto userDto);
}
