package com.karolk.dto;

import com.karolk.model.FoodItem;
import com.karolk.model.FoodNutrients;

import java.util.List;

public class FoodsDto {
    private List<FoodNutrients> foodNutrients;

    public FoodsDto(){}

    public FoodsDto(List<FoodNutrients> foodNutrients) {
        this.foodNutrients = foodNutrients;
    }

    public List<FoodNutrients> getFoodNutrients() {
        return foodNutrients;
    }

    public void setFoodNutrients(List<FoodNutrients> foodNutrients) {
        this.foodNutrients = foodNutrients;
    }
}
