package com.karolk.service;

import com.karolk.dto.UserDto;
import com.karolk.exception.InvalidUserException;
import com.karolk.model.User;
import com.karolk.repository.UserRepository;
import com.karolk.util.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;


    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(UserMapper.INSTANCE::convertEntityUserToUserDto)
                .collect(Collectors.toList());
    }

    public Optional<UserDto> findById(Long userId) {
        return userRepository.findById(userId).map(UserMapper.INSTANCE::convertEntityUserToUserDto);
    }

    public UserDto update(UserDto userDto) {
        Optional<User> userEntity = userRepository.findById(userDto.getId());
        userEntity.ifPresent((user -> {
            if(!(user.getId().equals(userDto.getId())))
                throw new InvalidUserException("The user's id to be updated does not match any user in the databse.");
        }));
        UserDto updatedUser = this.save(userDto);
        return updatedUser;
    }

    public UserDto save(UserDto userDto) {
        User user = UserMapper.INSTANCE.convertUserDtoToEntityUser(userDto);
        user.setCaloriesDemand();
        User savedUser = userRepository.save(user);
        return UserMapper.INSTANCE.convertEntityUserToUserDto(savedUser);
    }
}
