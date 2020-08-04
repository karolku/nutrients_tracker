package com.karolk.dto;

import com.karolk.model.FoodEntry;
import com.karolk.model.Foods;
import com.karolk.model.User;

import java.sql.Timestamp;
import java.util.Objects;

public class FoodEntryDto {

    private Long id;
    private User user;
    private Foods fdcId;
    private double amountOfServing;
    private String servingType;
    private Timestamp timestamp;
    private FoodEntry.MealTime mealTime;

    public FoodEntryDto() {
    }

    public FoodEntryDto(User user, Foods fdcId, double amountOfServing, String servingType, Timestamp timestamp, FoodEntry.MealTime mealTime) {
        this.user = user;
        this.fdcId = fdcId;
        this.amountOfServing = amountOfServing;
        this.servingType = servingType;
        this.timestamp = timestamp;
        this.mealTime = mealTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Foods getFdcId() {
        return fdcId;
    }

    public void setFdcId(Foods fdcId) {
        this.fdcId = fdcId;
    }

    public double getAmountOfServing() {
        return amountOfServing;
    }

    public void setAmountOfServing(double amountOfServing) {
        this.amountOfServing = amountOfServing;
    }

    public String getServingType() {
        return servingType;
    }

    public void setServingType(String servingType) {
        this.servingType = servingType;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public FoodEntry.MealTime getMealTime() {
        return mealTime;
    }

    public void setMealTime(FoodEntry.MealTime mealTime) {
        this.mealTime = mealTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodEntryDto that = (FoodEntryDto) o;
        return Double.compare(that.amountOfServing, amountOfServing) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(user, that.user) &&
                Objects.equals(fdcId, that.fdcId) &&
                Objects.equals(servingType, that.servingType) &&
                Objects.equals(timestamp, that.timestamp) &&
                mealTime == that.mealTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, fdcId, amountOfServing, servingType, timestamp, mealTime);
    }

    @Override
    public String toString() {
        return "FoodEntryDto{" +
                "id=" + id +
                ", user=" + user +
                ", fdcId=" + fdcId +
                ", amountOfServing=" + amountOfServing +
                ", servingType='" + servingType + '\'' +
                ", timestamp=" + timestamp +
                ", mealTime=" + mealTime +
                '}';
    }
}