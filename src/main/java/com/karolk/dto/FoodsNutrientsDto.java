package com.karolk.dto;

import com.karolk.model.Foods;
import com.karolk.model.FoodsNutrients;
import com.karolk.model.Nutrients;

import java.util.Objects;

public class FoodsNutrientsDto {
    private Long id;
    private Foods foods;
    private Nutrients nutrients;
    private double value;
    private FoodsNutrients foodsNutrients;

    public FoodsNutrientsDto() {
    }

    public FoodsNutrientsDto(Long id, Foods foodId, Nutrients nutrientId,
                             double value, FoodsNutrients foodsNutrients) {
        this.id = id;
        this.foods = foodId;
        this.nutrients = nutrientId;
        this.value = value;
        this.foodsNutrients = foodsNutrients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Foods getFoods() {
        return foods;
    }

    public void setFoods(Foods foods) {
        this.foods = foods;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public FoodsNutrients getFoodsNutrients() {
        return foodsNutrients;
    }

    public void setFoodsNutrients(FoodsNutrients foodsNutrients) {
        this.foodsNutrients = foodsNutrients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodsNutrientsDto that = (FoodsNutrientsDto) o;
        return Double.compare(that.value, value) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(foods, that.foods) &&
                Objects.equals(nutrients, that.nutrients) &&
                Objects.equals(foodsNutrients, that.foodsNutrients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, foods, nutrients, value, foodsNutrients);
    }

    @Override
    public String toString() {
        return "FoodsNutrientsDto{" +
                "id=" + id +
                ", foodId=" + foods +
                ", nutrientId=" + nutrients +
                ", value=" + value +
                ", foodsNutrients=" + foodsNutrients +
                '}';
    }
}
