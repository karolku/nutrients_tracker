package com.karolk.dto;

import com.karolk.model.FoodItem;
import com.karolk.model.FoodNutrients;

import java.util.List;

public class FoodsDto {

    private Long fdcId;
    private String description;
    private String brandOwner;
    private List<FoodNutrients> foodNutrients;

    public FoodsDto(){}

    public FoodsDto(Long fdcId, String description, String brandOwner, List<FoodNutrients> foodNutrients) {
        this.fdcId = fdcId;
        this.description = description;
        this.brandOwner = brandOwner;
        this.foodNutrients = foodNutrients;
    }

    public List<FoodNutrients> getFoodNutrients() {
        return foodNutrients;
    }

    public void setFoodNutrients(List<FoodNutrients> foodNutrients) {
        this.foodNutrients = foodNutrients;
    }
}
