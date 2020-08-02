package com.karolk.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String gender;

    @Column(name = "birthday_date")
    private Date birthdayDate;

    private String password;
    private String email;

    @Column(name = "account_created_time")
    private Timestamp accountCreatedTime;

    @Column(name = "last_updated_time")
    private Timestamp lastUpdatedtime;

    @Column(name = "wieght_in_kg")
    private double weightInKg;

    @Column(name = "height_in_cm")
    private double heightInCm;

    @Column(name = "activity_level")
    private double activityLevel;

    public User() {
    }

    public User(String firstName, String lastName, String gender, Date birthdayDate,
                String password, String email, Timestamp accountCreatedTime,
                Timestamp lastUpdatedtime, double weightInKg, double heightInCm,
                double activityLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdayDate = birthdayDate;
        this.password = password;
        this.email = email;
        this.accountCreatedTime = accountCreatedTime;
        this.lastUpdatedtime = lastUpdatedtime;
        this.weightInKg = weightInKg;
        this.heightInCm = heightInCm;
        this.activityLevel = activityLevel;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Timestamp getAccountCreatedTime() {
        return accountCreatedTime;
    }

    public void setAccountCreatedTime(Timestamp accountCreatedTime) {
        this.accountCreatedTime = accountCreatedTime;
    }

    public Timestamp getLastUpdatedtime() {
        return lastUpdatedtime;
    }

    public void setLastUpdatedtime(Timestamp lastUpdatedtime) {
        this.lastUpdatedtime = lastUpdatedtime;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
