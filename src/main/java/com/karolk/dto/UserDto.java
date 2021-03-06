package com.karolk.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String birthdayDate;
    private String email;
    private String password;
    private double weightInKg;
    private double heightInCm;
    private String activityLevel;
    private int caloriesDemand;
    private String jwt;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String gender,
                   String birthdayDate, String email, String password, double weightInKg,
                   double heightInCm, String activityLevel, int caloriesDemand, String jwt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdayDate = birthdayDate;
        this.email = email;
        this.password = password;
        this.weightInKg = weightInKg;
        this.heightInCm = heightInCm;
        this.activityLevel = activityLevel;
        this.caloriesDemand = caloriesDemand;
        this.jwt = jwt;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(double weightInKg) {
        this.weightInKg = weightInKg;
    }

    public double getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(double heightInCm) {
        this.heightInCm = heightInCm;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public int getCaloriesDemand() {
        return caloriesDemand;
    }

    public void setCaloriesDemand(int caloriesDemand) {
        this.caloriesDemand = caloriesDemand;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Double.compare(userDto.weightInKg, weightInKg) == 0 &&
                Double.compare(userDto.heightInCm, heightInCm) == 0 &&
                caloriesDemand == userDto.caloriesDemand &&
                Objects.equals(id, userDto.id) &&
                Objects.equals(firstName, userDto.firstName) &&
                Objects.equals(lastName, userDto.lastName) &&
                Objects.equals(gender, userDto.gender) &&
                Objects.equals(birthdayDate, userDto.birthdayDate) &&
                Objects.equals(email, userDto.email) &&
                Objects.equals(password, userDto.password) &&
                Objects.equals(activityLevel, userDto.activityLevel) &&
                Objects.equals(jwt, userDto.jwt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender, birthdayDate, email, password,
                weightInKg, heightInCm, activityLevel, caloriesDemand, jwt);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdayDate=" + birthdayDate +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", weightInKg=" + weightInKg +
                ", heightInCm=" + heightInCm +
                ", activityLevel=" + activityLevel +
                ", caloriesDemand=" + caloriesDemand +
                ", jwt=" + jwt +
                '}';
    }
}
