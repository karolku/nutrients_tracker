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
                throw new InvalidUserException("User with this id");
        }));
        User userToBeUpdated = UserMapper.INSTANCE.convertUserDtoToEntityUser(userDto);
        User updatedUser = userRepository.save(userToBeUpdated);
        return UserMapper.INSTANCE.convertEntityUserToUserDto(updatedUser);
    }

    public UserDto save(UserDto userDto) {
        User user = UserMapper.INSTANCE.convertUserDtoToEntityUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.INSTANCE.convertEntityUserToUserDto(savedUser);
    }
}
