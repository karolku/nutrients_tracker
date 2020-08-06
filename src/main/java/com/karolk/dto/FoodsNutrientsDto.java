package com.karolk.dto;

import java.util.Objects;

public class FoodsNutrientsDto {
    private Long id;
    private Long foodId;
    private Long nutrientId;

    public FoodsNutrientsDto() {
    }

    public FoodsNutrientsDto(Long id, Long foodId, Long nutrientId) {
        this.id = id;
        this.foodId = foodId;
        this.nutrientId = nutrientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public Long getNutrientId() {
        return nutrientId;
    }

    public void setNutrientId(Long nutrientId) {
        this.nutrientId = nutrientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodsNutrientsDto that = (FoodsNutrientsDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(foodId, that.foodId) &&
                Objects.equals(nutrientId, that.nutrientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, foodId, nutrientId);
    }

    @Override
    public String toString() {
        return "FoodsNutrientsDto{" +
                "id=" + id +
                ", foodId=" + foodId +
                ", nutrientId=" + nutrientId +
                '}';
    }
}
