package com.karolk.service;

import com.karolk.dto.LoginAuthenticationRequest;
import com.karolk.dto.LoginAuthenticationResponse;
import com.karolk.dto.UserDto;
import com.karolk.model.User;
import com.karolk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                                AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public void signup(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        if (userDto.getGender() != null) {
            user.setGender((User.Gender)Enum.valueOf(User.Gender.class, userDto.getGender()));
        }
        user.setBirthdayDate(userDto.getBirthdayDate());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setWeightInKg(userDto.getWeightInKg());
        user.setHeightInCm(userDto.getHeightInCm());
        user.setActivityLevel(userDto.getActivityLevel());
        user.setCaloriesDemand();

        userRepository.save(user);
    }

    public LoginAuthenticationResponse authenticateLogin(LoginAuthenticationRequest loginAuthenticationRequest) {

    }
}
