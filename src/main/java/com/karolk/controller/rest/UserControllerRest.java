package com.karolk.controller.rest;

import com.karolk.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserControllerRest {
    private UserService userService;

    public UserControllerRest(UserService userService){
        this.userService = userService;
    }
}
