package com.karolk.dto;

public class LoginAuthenticationResponse {

    private Long id;
    private String jwt;
    private String username;

    public LoginAuthenticationResponse(String jwt, String username, Long id) {
        this.jwt = jwt;
        this.username = username;
        this.id = id;
    }

    public String getJwt() {
        return jwt;
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
