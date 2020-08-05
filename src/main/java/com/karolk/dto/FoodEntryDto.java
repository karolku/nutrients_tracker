package com.karolk.dto;

import com.karolk.model.FoodEntry;

import java.sql.Date;
import java.util.Objects;

public class FoodEntryDto {

    private Long id;
    private Long userId;
    private Long fdcId;
    private double amountOfServing;
    private String servingType;
    private Date dateOfFoodEntry;
    private FoodEntry.MealTime mealTime;

    public FoodEntryDto() {
    }

    public FoodEntryDto(Long userId, Long fdcId, double amountOfServing, String servingType,
                        Date dateOfFoodEntry, FoodEntry.MealTime mealTime) {
        this.userId = userId;
        this.fdcId = fdcId;
        this.amountOfServing = amountOfServing;
        this.servingType = servingType;
        this.dateOfFoodEntry = dateOfFoodEntry;
        this.mealTime = mealTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFdcId() {
        return fdcId;
    }

    public void setFdcId(Long fdcId) {
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

    public Date getDateOfFoodEntry() {
        return dateOfFoodEntry;
    }

    public void setDateOfFoodEntry(Date dateOfFoodEntry) {
        this.dateOfFoodEntry = dateOfFoodEntry;
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
                Objects.equals(userId, that.userId) &&
                Objects.equals(fdcId, that.fdcId) &&
                Objects.equals(servingType, that.servingType) &&
                Objects.equals(dateOfFoodEntry, that.dateOfFoodEntry) &&
                mealTime == that.mealTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, fdcId, amountOfServing, servingType, dateOfFoodEntry, mealTime);
    }

    @Override
    public String toString() {
        return "FoodEntryDto{" +
                "id=" + id +
                ", user=" + userId +
                ", fdcId=" + fdcId +
                ", amountOfServing=" + amountOfServing +
                ", servingType='" + servingType + '\'' +
                ", timestamp=" + dateOfFoodEntry +
                ", mealTime=" + mealTime +
                '}';
    }
}
