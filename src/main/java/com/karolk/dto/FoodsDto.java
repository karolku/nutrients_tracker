package com.karolk.dto;

import java.util.List;

public class FoodsDto {

    private Long id;
    private Long fdcId;
    private String description;
    private String brandOwner;
    private List<NutrientsDto> nutrientsDtoList;

    public FoodsDto(){}

    public FoodsDto(Long fdcId, String description, String brandOwner, List<NutrientsDto> nutrientsDtoList) {
        this.fdcId = fdcId;
        this.description = description;
        this.brandOwner = brandOwner;
        this.nutrientsDtoList = nutrientsDtoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<NutrientsDto> getNutrientsDtoList() {
        return nutrientsDtoList;
    }

    public void setNutrientsDtoList(List<NutrientsDto> nutrientsDtoList) {
        this.nutrientsDtoList = nutrientsDtoList;
    }

    @Override
    public String toString() {
        return "FoodsDto{" +
                "id=" + id +
                ", fdcId=" + fdcId +
                ", description='" + description + '\'' +
                ", brandOwner='" + brandOwner + '\'' +
                ", nutrientsDtoList=" + nutrientsDtoList +
                '}';
    }
}
