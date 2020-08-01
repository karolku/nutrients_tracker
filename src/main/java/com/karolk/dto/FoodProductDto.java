package com.karolk.dto;

import com.karolk.model.FoodNutrients;

import java.util.List;

public class FoodProductDto {
    private List<FoodNutrients> foodNutrients;

    public FoodProductDto(List<FoodNutrients> foodNutrients) {
        this.foodNutrients = foodNutrients;
    }

    public List<FoodNutrients> getFoodNutrients() {
        return foodNutrients;
    }

    public void setFoodNutrients(List<FoodNutrients> foodNutrients) {
        this.foodNutrients = foodNutrients;
    }
}
