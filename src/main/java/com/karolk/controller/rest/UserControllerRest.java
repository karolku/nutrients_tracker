package com.karolk.controller.rest;

import com.karolk.dto.UserDto;
import com.karolk.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserControllerRest {
    private UserService userService;

    public UserControllerRest(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    List<UserDto> findAllUsers(){
        return userService.findAllUsers();
    }
}
