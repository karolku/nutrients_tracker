package com.karolk.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "food_entry")
public class FoodEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private User userId;
    private Foods foods;
    private double amountOfServing; // all data will be provided per 100 grams. so amount of 1 = 100 grams.
    private String servingType;
    private Timestamp timestamp;
    private String mealTime;

    public FoodEntry() {
    }

    public FoodEntry(User userId, Foods foods, double quantity, String servingType,
                     Timestamp timestamp, String mealTime) {
        this.userId = userId;
        this.foods = foods;
        this.amountOfServing = quantity;
        this.servingType = servingType;
        this.timestamp = timestamp;
        this.mealTime = mealTime;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Foods getFoods() {
        return foods;
    }

    public void setFoods(Foods foods) {
        this.foods = foods;
    }

    public double getAmountOfServing() {
        return amountOfServing;
    }

    public void setAmountOfServing(double amountOfServing) {
        this.amountOfServing = amountOfServing;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        if(mealTime.equals("Breakfast") ||
                mealTime.equals("Lunch") ||
                mealTime.equals("Dinner") ||
                mealTime.equals("Snack"))
                this.mealTime = mealTime;
        else
            System.out.println("Some exception will be send to the client.");
    }

    public String getServingType() {
        return servingType;
    }

    public void setServingType(String servingType) {
        this.servingType = servingType;
    }

    @Override
    public String toString() {
        return "FoodEntry{" +
                "userId=" + userId +
                ", fdcId=" + foods +
                ", quantity=" + amountOfServing +
                ", timestamp=" + timestamp +
                ", mealTime='" + mealTime + '\'' +
                '}';
    }
}
