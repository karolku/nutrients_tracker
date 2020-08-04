package com.karolk.service;

import com.karolk.dto.UserDto;
import com.karolk.model.User;
import com.karolk.repository.UserRepository;
import com.karolk.util.UserMapper;
import com.karolk.util.UserMapperImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;


    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAllUser(){
        return userRepository.findAll()
                .stream()
                .map(UserMapper.INSTANCE.convertUserToUserDto())
                .collect(Collectors.toList());
    }
}
