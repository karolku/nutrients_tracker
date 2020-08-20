package com.karolk.dto;

public class LoginAuthenticationResponse {

    private String jwt;
    private String username;

    public LoginAuthenticationResponse(String jwt, String username) {
        this.jwt = jwt;
        this.username = username;
    }

    public String getJwt() {
        return jwt;
    }

    public String getUsername() {
        return username;
    }
}
