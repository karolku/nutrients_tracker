package com.karolk.nutrientstracker;

import com.karolk.repository.UserRepository;
import com.karolk.service.UserService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestUserService {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;
}
