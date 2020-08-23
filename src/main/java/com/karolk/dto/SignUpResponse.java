package com.karolk.dto;

import com.karolk.model.User;

import java.util.Objects;

public class SignUpResponse {

    private Long id;
    private String firstName;
    private String email;

    public SignUpResponse(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.email = user.getEmail();
    }

    public SignUpResponse(Long id, String firstName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignUpResponse that = (SignUpResponse) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, email);
    }

    @Override
    public String toString() {
        return "SignUpResponse{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
