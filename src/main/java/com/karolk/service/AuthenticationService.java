package com.karolk.service;

import com.karolk.dto.LoginAuthenticationRequest;
import com.karolk.dto.LoginAuthenticationResponse;
import com.karolk.dto.SignUpResponse;
import com.karolk.dto.UserDto;
import com.karolk.exception.InvalidUserException;
import com.karolk.model.User;
import com.karolk.repository.UserRepository;
import com.karolk.util.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private UserDetailsServiceImpl userDetailsService;
    private JwtProvider jwtProvider;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                                AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService,
                                 JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtProvider = jwtProvider;
    }

    public SignUpResponse signup(UserDto userDto) {
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
        user.setActive(true);
        userRepository.save(user);

        SignUpResponse signUpResponse = new SignUpResponse(user);
        return signUpResponse;
    }

    public LoginAuthenticationResponse authenticateLogin(LoginAuthenticationRequest loginAuthenticationRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginAuthenticationRequest.getEmail(), loginAuthenticationRequest.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginAuthenticationRequest.getEmail());
        String jwt = jwtProvider.generateToken(userDetails);
        Optional<User> user = userRepository.findUserByEmail(loginAuthenticationRequest.getEmail());
        user.orElseThrow(() -> new InvalidUserException("There is no user with provided email: " + loginAuthenticationRequest.getEmail()));

        return new LoginAuthenticationResponse(jwt, user.get().getFirstName());
    }
}
