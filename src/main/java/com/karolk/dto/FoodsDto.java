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

    public Long getFdcId() {
        return fdcId;
    }

    public void setFdcId(Long fdcId) {
        this.fdcId = fdcId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrandOwner() {
        return brandOwner;
    }

    public void setBrandOwner(String brandOwner) {
        this.brandOwner = brandOwner;
    }
}