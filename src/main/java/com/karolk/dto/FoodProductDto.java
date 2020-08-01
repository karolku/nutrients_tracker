package com.karolk.dto;

import com.karolk.model.Foods;

import java.util.List;

public class FoodProductDto {
    private List<Foods> foodsList;

    public FoodProductDto(List<Foods> foodsList) {
        this.foodsList = foodsList;
    }

    public List<Foods> getFoodsList() {
        return foodsList;
    }

    public void setFoodsList(List<Foods> foodsList) {
        this.foodsList = foodsList;
    }
}
