package com.karolk.nutrientstracker;

import com.karolk.dto.UserDto;
import com.karolk.model.User;
import com.karolk.repository.UserRepository;
import com.karolk.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestUserService {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Test
    public void findAllUsers() {
        List<User> userList = new ArrayList<>();
        User user1 = new User("John", "Deep", User.Gender.MALE, LocalDate.of(1970,10,15),"pass1",
                "john01@email.com", (double)78.5,(double)178.0, (double)1.2, 1600, true);
        User user2 = new User("Mike", "Test", User.Gender.MALE, LocalDate.of(1978,11,19),"passdsds1",
                "mike01@email.com", (double)88.5,(double)188.0, (double)1.2, 1600, true);
        userList.add(user1);
        userList.add(user2);

        when(userRepository.findAll()).thenReturn(userList);

        List<UserDto> userListFromService = userService.findAllUsers();
        assertEquals(2,userList.size());
        verify(userRepository, times(1)).findAll();
    }
}
