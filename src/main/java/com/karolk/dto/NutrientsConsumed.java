package com.karolk.dto;

import com.karolk.util.Round;

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

    public void addCalories(double calories) {
        double rounded = Round.roundToTwoDecimal(this.calories += calories);
        this.calories = rounded;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void addProtein(double protein) {
        double rounded = Round.roundToTwoDecimal(this.protein += protein);
        this.protein = rounded;
    }

    public double getCarbohydrated() {
        return carbohydrated;
    }

    public void setCarbohydrated(double carbohydrated) {
        this.carbohydrated = carbohydrated;
    }

    public void addCarbohydrated(double carbohydrated) {
        double rounded = Round.roundToTwoDecimal(this.carbohydrated += carbohydrated);
        this.carbohydrated = rounded;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void addFat(double fat) {
        double rounded = Round.roundToTwoDecimal(this.fat += fat);
        this.fat = rounded;
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
