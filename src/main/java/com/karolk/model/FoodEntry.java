package com.karolk.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "food_entry")
public class FoodEntry implements Serializable {

    private static final long serialVersionUID = 42L;

    public enum MealTime {
        BREAKFAST, LUNCH, DINNER, SNACK;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_entry_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id" )
    private User userId;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Foods foodId;

    @Column(name = "amount_of_serving")
    private double amountOfServing; // all data will be provided per 100 grams. so amount of 1 = 100 grams.

    @Column(name = "serving_type")
    private String servingType;

    @Column(name = "time_stamp")
    private Date dateOfFoodEntry;

    @Column(name = "meal_time")
    @Enumerated(EnumType.STRING)
    private MealTime mealTime;

    public FoodEntry() {
    }

    public FoodEntry(User userId, Foods foodId, double quantity, String servingType,
                     Date dateOfFoodEntry, MealTime mealTime) {
        this.userId = userId;
        this.foodId = foodId;
        this.amountOfServing = quantity;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Foods getFoodId() {
        return foodId;
    }

    public void setFoodId(Foods foodId) {
        this.foodId = foodId;
    }

    public double getAmountOfServing() {
        return amountOfServing;
    }

    public void setAmountOfServing(double amountOfServing) {
        this.amountOfServing = amountOfServing;
    }

    public Date getDateOfFoodEntry() {
        return dateOfFoodEntry;
    }

    public void setDateOfFoodEntry(Date dateOfFoodEntry) {
        this.dateOfFoodEntry = dateOfFoodEntry;
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
                Objects.equals(userId, foodEntry.userId) &&
                Objects.equals(foodId, foodEntry.foodId) &&
                Objects.equals(servingType, foodEntry.servingType) &&
                Objects.equals(dateOfFoodEntry, foodEntry.dateOfFoodEntry) &&
                Objects.equals(mealTime, foodEntry.mealTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, foodId, amountOfServing, servingType, dateOfFoodEntry, mealTime);
    }

    @Override
    public String toString() {
        return "FoodEntry{" +
                "userId=" + userId +
                ", fdcId=" + foodId +
                ", quantity=" + amountOfServing +
                ", dateOfFoodEntry=" + dateOfFoodEntry +
                ", mealTime='" + mealTime + '\'' +
                '}';
    }
}
