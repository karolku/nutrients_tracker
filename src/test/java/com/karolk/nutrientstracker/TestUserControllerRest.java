package com.karolk.nutrientstracker;

import com.karolk.controller.rest.UserControllerRest;
import com.karolk.repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUserControllerRest {

    @InjectMocks
    UserControllerRest userRest;

    @Mock
    UserRepository userRepository;
}
