package com.karolk.util;

import com.karolk.dto.UserDto;
import com.karolk.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true)
    UserDto convertEntityUserToUserDto(User user);

    @Mapping(target = "caloriesDemand", ignore = true)
    User convertUserDtoToEntityUser(UserDto userDto);

    default double toDouble(User.ActivityLevel activityLevel) {
        return activityLevel.getActivityValue();
    }
}
