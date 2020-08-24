package com.karolk.controller.rest;

import com.karolk.dto.LoginAuthenticationRequest;
import com.karolk.dto.LoginAuthenticationResponse;
import com.karolk.dto.SignUpResponse;
import com.karolk.dto.UserDto;
import com.karolk.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody UserDto userDto) {
        SignUpResponse signUpResponse = authenticationService.signup(userDto);
        return ResponseEntity.ok(signUpResponse);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginAuthenticationRequest loginAuthenticationRequest) throws Exception {
        return authenticationService.authenticateLogin(loginAuthenticationRequest)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
