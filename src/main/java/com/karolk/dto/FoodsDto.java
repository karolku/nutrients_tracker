package com.karolk.dto;

public class FoodsDto {

    private Long id;
    private Long fdcId;
    private String description;
    private String brandOwner;
    private NutrientsDto nutrientsDto;

    public FoodsDto(){}

    public FoodsDto(Long fdcId, String description, String brandOwner, NutrientsDto nutrientsDto) {
        this.fdcId = fdcId;
        this.description = description;
        this.brandOwner = brandOwner;
        this.nutrientsDto = nutrientsDto;
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

    public NutrientsDto getNutrientsDto() {
        return nutrientsDto;
    }

    public void setNutrientsDto(NutrientsDto nutrientsDto) {
        this.nutrientsDto = nutrientsDto;
    }

    @Override
    public String toString() {
        return "FoodsDto{" +
                "id=" + id +
                ", fdcId=" + fdcId +
                ", description='" + description + '\'' +
                ", brandOwner='" + brandOwner + '\'' +
                ", nutrientsDto=" + nutrientsDto +
                '}';
    }
}
