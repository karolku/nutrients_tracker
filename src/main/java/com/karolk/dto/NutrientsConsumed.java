package com.karolk.dto;

public class NutrientsConsumed {
    private double calories;
    private double protein;
    private double carbohydrated;
    private double fat;

    public NutrientsConsumed() {
    }

    public NutrientsConsumed(double calories, double protein, double carbohydrated, double fat) {
        this.calories = calories;
        this.protein = protein;
        this.carbohydrated = carbohydrated;
        this.fat = fat;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbohydrated() {
        return carbohydrated;
    }

    public void setCarbohydrated(double carbohydrated) {
        this.carbohydrated = carbohydrated;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    @Override
    public String toString() {
        return "NutrientsConsumed{" +
                "calories=" + calories +
                ", protein=" + protein +
                ", carbohydrated=" + carbohydrated +
                ", fat=" + fat +
                '}';
    }
}
