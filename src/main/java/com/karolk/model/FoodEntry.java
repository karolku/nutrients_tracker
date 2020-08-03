package com.karolk.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "food_entry")
public class FoodEntry implements Serializable {

    private static final long serialVersionUID = 42L;

    public enum MealTime {
        BREAKFAST, LUNCH, DINNER, SNACK
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_entry_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id" )
    private User user;

    @ManyToOne
    @JoinColumn(name = "fdcId")
    private Foods fdcId;

    @Column(name = "amount_of_serving")
    private double amountOfServing; // all data will be provided per 100 grams. so amount of 1 = 100 grams.

    @Column(name = "serving_type")
    private String servingType;

    @Column(name = "time_stamp")
    private Timestamp timestamp;

    @Column(name = "meal_time")
    private MealTime mealTime;

    public FoodEntry() {
    }

    public FoodEntry(User userId, Foods fdcId, double quantity, String servingType,
                     Timestamp timestamp, MealTime mealTime) {
        this.user = userId;
        this.fdcId = fdcId;
        this.amountOfServing = quantity;
        this.servingType = servingType;
        this.timestamp = timestamp;
        this.mealTime = mealTime;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public MealTime getMealTime() {
        return mealTime;
    }

    public void setMealTime(MealTime mealTime) {
                this.mealTime = mealTime;
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
                Objects.equals(user, foodEntry.user) &&
                Objects.equals(fdcId, foodEntry.fdcId) &&
                Objects.equals(servingType, foodEntry.servingType) &&
                Objects.equals(timestamp, foodEntry.timestamp) &&
                Objects.equals(mealTime, foodEntry.mealTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, fdcId, amountOfServing, servingType, timestamp, mealTime);
    }

    @Override
    public String toString() {
        return "FoodEntry{" +
                "userId=" + user +
                ", fdcId=" + fdcId +
                ", quantity=" + amountOfServing +
                ", timestamp=" + timestamp +
                ", mealTime='" + mealTime + '\'' +
                '}';
    }
}
