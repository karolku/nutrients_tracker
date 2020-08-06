package com.karolk.dto;

import com.karolk.model.FoodEntry;

import java.sql.Date;
import java.util.Objects;

public class FoodEntryDto {

    private Long food_entry_id;
    private Long userId;
    private Long foodId;
    private double amountOfServing;
    private String servingType;
    private Date dateOfFoodEntry;
    private FoodEntry.MealTime mealTime;

    public FoodEntryDto() {
    }

    public FoodEntryDto(Long userId, Long foodId, double amountOfServing, String servingType,
                        Date dateOfFoodEntry, FoodEntry.MealTime mealTime) {
        this.userId = userId;
        this.foodId = foodId;
        this.amountOfServing = amountOfServing;
        this.servingType = servingType;
        this.dateOfFoodEntry = dateOfFoodEntry;
        this.mealTime = mealTime;
    }

    public Long getFood_entry_id() {
        return food_entry_id;
    }

    public void setFood_entry_id(Long food_entry_id) {
        this.food_entry_id = food_entry_id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
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
                Objects.equals(food_entry_id, that.food_entry_id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(foodId, that.foodId) &&
                Objects.equals(servingType, that.servingType) &&
                Objects.equals(dateOfFoodEntry, that.dateOfFoodEntry) &&
                mealTime == that.mealTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(food_entry_id, userId, foodId, amountOfServing, servingType, dateOfFoodEntry, mealTime);
    }

    @Override
    public String toString() {
        return "FoodEntryDto{" +
                "id=" + food_entry_id +
                ", user=" + userId +
                ", fdcId=" + foodId +
                ", amountOfServing=" + amountOfServing +
                ", servingType='" + servingType + '\'' +
                ", timestamp=" + dateOfFoodEntry +
                ", mealTime=" + mealTime +
                '}';
    }
}
