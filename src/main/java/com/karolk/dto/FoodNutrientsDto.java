package com.karolk.dto;

public class FoodNutrientsDto {

    private Long id;
    private Long nutrientId;
    private String nutrientName;
    private String unitName;
    private double value;

    public FoodNutrientsDto() {}

    public FoodNutrientsDto(Long nutrientId, String nutrientName, String unitName, double value) {
        this.nutrientId = nutrientId;
        this.nutrientName = nutrientName;
        this.unitName = unitName;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNutrientId() {
        return nutrientId;
    }

    public void setNutrientId(Long nutrientId) {
        this.nutrientId = nutrientId;
    }

    public String getNutrientName() {
        return nutrientName;
    }

    public void setNutrientName(String nutrientName) {
        this.nutrientName = nutrientName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
