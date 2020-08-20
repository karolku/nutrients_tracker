package com.karolk.controller.rest;

import com.karolk.dto.LoginAuthenticationRequest;
import com.karolk.dto.LoginAuthenticationResponse;
import com.karolk.dto.UserDto;
import com.karolk.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody UserDto userDto) {
        authenticationService.signup(userDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginAuthenticationRequest loginAuthenticationRequest) throws Exception {
        LoginAuthenticationResponse loginAuthenticationResponse;
        try {
            loginAuthenticationResponse = authenticationService.authenticateLogin(loginAuthenticationRequest);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).
                    body("Invalid email or password for user ");
        }
        return ResponseEntity.ok(loginAuthenticationResponse);
    }
}
