package com.karolk.model;

import java.sql.Timestamp;

public class FoodEntry {

    private Long id;
    private User userId;
    private Foods fdcId;
    private double amountOfServing;
    private Timestamp timestamp;
    private String mealTime;

    public FoodEntry() {
    }

    public FoodEntry(User userId, Foods fdcId, double quantity,
                     Timestamp timestamp, String mealTime) {
        this.userId = userId;
        this.fdcId = fdcId;
        this.amountOfServing = quantity;
        this.timestamp = timestamp;
        this.mealTime = mealTime;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "FoodEntry{" +
                "userId=" + userId +
                ", fdcId=" + fdcId +
                ", quantity=" + amountOfServing +
                ", timestamp=" + timestamp +
                ", mealTime='" + mealTime + '\'' +
                '}';
    }
}
