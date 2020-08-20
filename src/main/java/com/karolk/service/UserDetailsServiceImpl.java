package com.karolk.service;

import com.karolk.exception.InvalidUserException;
import com.karolk.model.User;
import com.karolk.model.UserDetailsImpl;
import com.karolk.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByEmail(email);
        user.orElseThrow(() -> new InvalidUserException("Provided user has not been found: " + email));
        return user.map(UserDetailsImpl::new).get();
    }
}
