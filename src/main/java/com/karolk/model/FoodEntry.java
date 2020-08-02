package com.karolk.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "food_entry")
public class FoodEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_entry_id")
    private Long id;

    @Column(name = "user_id")
    private User userId;

    private Foods foods;

    @Column(name = "amount_of_serving")
    private double amountOfServing; // all data will be provided per 100 grams. so amount of 1 = 100 grams.

    @Column(name = "serving_type")
    private String servingType;

    @Column(name = "time_stamp")
    private Timestamp timestamp;

    @Column(name = "meal_time")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodEntry foodEntry = (FoodEntry) o;
        return Double.compare(foodEntry.amountOfServing, amountOfServing) == 0 &&
                Objects.equals(id, foodEntry.id) &&
                Objects.equals(userId, foodEntry.userId) &&
                Objects.equals(foods, foodEntry.foods) &&
                Objects.equals(servingType, foodEntry.servingType) &&
                Objects.equals(timestamp, foodEntry.timestamp) &&
                Objects.equals(mealTime, foodEntry.mealTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, foods, amountOfServing, servingType, timestamp, mealTime);
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
