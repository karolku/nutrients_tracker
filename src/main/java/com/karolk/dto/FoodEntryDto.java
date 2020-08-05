package com.karolk.dto;

import com.karolk.model.FoodEntry;
import com.karolk.model.Foods;
import com.karolk.model.User;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class FoodEntryDto {

    private Long id;
    private Long user_id;
    private Long fdcId;
    private double amountOfServing;
    private String servingType;
    private Date dateOfFoodEntry;
    private FoodEntry.MealTime mealTime;

    public FoodEntryDto() {
    }

    public FoodEntryDto(Long user_id, Long fdcId, double amountOfServing, String servingType,
                        Date dateOfFoodEntry, FoodEntry.MealTime mealTime) {
        this.user_id = user_id;
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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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
                Objects.equals(user_id, that.user_id) &&
                Objects.equals(fdcId, that.fdcId) &&
                Objects.equals(servingType, that.servingType) &&
                Objects.equals(dateOfFoodEntry, that.dateOfFoodEntry) &&
                mealTime == that.mealTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, fdcId, amountOfServing, servingType, dateOfFoodEntry, mealTime);
    }

    @Override
    public String toString() {
        return "FoodEntryDto{" +
                "id=" + id +
                ", user=" + user_id +
                ", fdcId=" + fdcId +
                ", amountOfServing=" + amountOfServing +
                ", servingType='" + servingType + '\'' +
                ", timestamp=" + dateOfFoodEntry +
                ", mealTime=" + mealTime +
                '}';
    }
}
