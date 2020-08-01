package com.karolk.dto;

import com.karolk.model.FoodNutrients;

import java.util.List;

public class FoodProductDto {
    private List<FoodNutrients> foodsList;

    public FoodProductDto(List<FoodNutrients> foodsList) {
        this.foodsList = foodsList;
    }

    public List<FoodNutrients> getFoodsList() {
        return foodsList;
    }

    public void setFoodsList(List<FoodNutrients> foodsList) {
        this.foodsList = foodsList;
    }
}
