package com.karolk.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Transient
    private final double BMR_CONSTANT_1 = 10.0;
    @Transient
    private final double BMR_CONSTANT_2 = 6.25;
    @Transient
    private final double BMR_CONSTANT_3 = 5.0;
    @Transient
    private final double BMR_CONSTANT_4 = 161;

    public enum Gender {
        MALE, FEMALE
    }

    public enum ActivityLevel {

        SEDENTARY(1.2), LOW_ACTIVITY(1.375), MODERATE_ACTIVITY(1.55), HIGH_ACTIVITY(1.725), VERY_HIGH_ACTIVITY(1.9);

        private double activity;

        ActivityLevel(double activity) {
            this.activity = activity;
        }

        public double getActivity(){
            return this.activity;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birthday_date")
    private Date birthdayDate;

    private String password;
    private String email;

    @Column(name = "weight_in_kg")
    private double weightInKg;

    @Column(name = "height_in_cm")
    private double heightInCm;

    @Column(name = "activity_level")
    private ActivityLevel activityLevel;

    @Column(name = "calories_demand")
    private double caloriesDemand;

    public User() {
    }

    public User(String firstName, String lastName, Gender gender, Date birthdayDate,
                String password, String email, double weightInKg, double heightInCm,
                ActivityLevel activityLevel, double caloriesDemand) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdayDate = birthdayDate;
        this.password = password;
        this.email = email;
        this.weightInKg = weightInKg;
        this.heightInCm = heightInCm;
        this.activityLevel = activityLevel;
        this.caloriesDemand = caloriesDemand;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
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

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    public double getCaloriesDemand() {
        return caloriesDemand;
    }

    public void setCaloriesDemand() {
        this.caloriesDemand = this.calculateCalories();
    }

    //Based on the BMR formula
    @Transient
    public double calculateCalories() {
        double calories = (BMR_CONSTANT_1 * weightInKg) + (BMR_CONSTANT_2 * heightInCm) - (BMR_CONSTANT_3 * age);
        if(gender.equals(Gender.MALE))
            calories += BMR_CONSTANT_3;
        else
            calories -= BMR_CONSTANT_4;
        return calories * activityLevel.getActivity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(user.weightInKg, weightInKg) == 0 &&
                Double.compare(user.heightInCm, heightInCm) == 0 &&
                Objects.equals(activityLevel, user.activityLevel) &&
                Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(birthdayDate, user.birthdayDate) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(caloriesDemand, this.caloriesDemand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender, birthdayDate,
                password, email, weightInKg, heightInCm, activityLevel, caloriesDemand);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", birthdayDate=" + birthdayDate +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", weightInKg=" + weightInKg +
                ", heightInCm=" + heightInCm +
                ", activityLevel=" + activityLevel +
                ", caloriesDemand=" + caloriesDemand +
                '}';
    }
}
