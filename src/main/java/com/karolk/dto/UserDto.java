package com.karolk.dto;

import com.karolk.model.FoodEntry;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthdayDate;
    private String email;
    private String password;
    private Timestamp lastUpdatedTime;
    private double weightInKg;
    private double heightInCm;
    private double activityLevel;
    private List<FoodEntry> foodEntries = new ArrayList<>();

    public UserDto() {
    }

    public UserDto(Long id, String firstName, String lastName, String gender,
                   Date birthdayDate, String email, String password, Timestamp lastUpdatedTime,
                   double weightInKg, double heightInCm, double activityLevel, List<FoodEntry> foodEntries) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdayDate = birthdayDate;
        this.email = email;
        this.password = password;
        this.lastUpdatedTime = lastUpdatedTime;
        this.weightInKg = weightInKg;
        this.heightInCm = heightInCm;
        this.activityLevel = activityLevel;
        this.foodEntries = foodEntries;
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

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
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

    public Timestamp getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Timestamp lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
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

    public double getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(double activityLevel) {
        this.activityLevel = activityLevel;
    }

    public List<FoodEntry> getFoodEntries() {
        return foodEntries;
    }

    public void setFoodEntries(List<FoodEntry> foodEntries) {
        this.foodEntries = foodEntries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Double.compare(userDto.weightInKg, weightInKg) == 0 &&
                Double.compare(userDto.heightInCm, heightInCm) == 0 &&
                Double.compare(userDto.activityLevel, activityLevel) == 0 &&
                Objects.equals(id, userDto.id) &&
                Objects.equals(firstName, userDto.firstName) &&
                Objects.equals(lastName, userDto.lastName) &&
                Objects.equals(gender, userDto.gender) &&
                Objects.equals(birthdayDate, userDto.birthdayDate) &&
                Objects.equals(email, userDto.email) &&
                Objects.equals(password, userDto.password) &&
                Objects.equals(lastUpdatedTime, userDto.lastUpdatedTime) &&
                Objects.equals(foodEntries, userDto.foodEntries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender, birthdayDate, email,
                password, lastUpdatedTime, weightInKg, heightInCm, activityLevel, foodEntries);
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
                ", lastUpdatedTime=" + lastUpdatedTime +
                ", weightInKg=" + weightInKg +
                ", heightInCm=" + heightInCm +
                ", activityLevel=" + activityLevel +
                ", foodEntries=" + foodEntries +
                '}';
    }
}