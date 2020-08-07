package com.karolk.dto;

import com.karolk.model.Foods;
import com.karolk.model.Nutrients;

import java.util.Objects;

public class FoodsNutrientsDto {
    private Long id;
    private Foods foods;
    private Nutrients nutrients;
    private double value;

    public FoodsNutrientsDto() {
    }

    public FoodsNutrientsDto(Long id, Foods foodId, Nutrients nutrientId, double value) {
        this.id = id;
        this.foods = foodId;
        this.nutrients = nutrientId;
        this.value = value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodsNutrientsDto that = (FoodsNutrientsDto) o;
        return Double.compare(that.value, value) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(foods, that.foods) &&
                Objects.equals(nutrients, that.nutrients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, foods, nutrients, value);
    }

    @Override
    public String toString() {
        return "FoodsNutrientsDto{" +
                "id=" + id +
                ", foodId=" + foods +
                ", nutrientId=" + nutrients +
                ", value=" + value +
                '}';
    }
}
