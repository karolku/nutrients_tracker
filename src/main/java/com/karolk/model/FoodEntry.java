package com.karolk.model;

import java.sql.Timestamp;

public class FoodEntry {
    private User userId;
    private Foods fdcId;
    private double quantity;
    private Timestamp timestamp;
    private String mealTime;

    public FoodEntry() {
    }

    public FoodEntry(User userId, Foods fdcId, double quantity,
                     Timestamp timestamp, String mealTime) {
        this.userId = userId;
        this.fdcId = fdcId;
        this.quantity = quantity;
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
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
        this.mealTime = mealTime;
    }

    @Override
    public String toString() {
        return "FoodEntry{" +
                "userId=" + userId +
                ", fdcId=" + fdcId +
                ", quantity=" + quantity +
                ", timestamp=" + timestamp +
                ", mealTime='" + mealTime + '\'' +
                '}';
    }
}
