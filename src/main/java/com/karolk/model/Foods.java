package com.karolk.model;

import java.util.List;

public class Foods {
    private Long fdcId;
    private String description;
    private String dataType;
    private String gtinUpc;
    private String publishedDate;
    private String brandOwner;
    private List<String> ingridients;
    private List<FoodNutrients> foodNutrients;

    public Foods() {
    }

    public Foods(Long fdcId, String description, String dataType, String gtinUpc,
                 String publishedDate, String brandOwner, List<String> ingridients,
                 List<FoodNutrients> foodNutrients) {
        this.fdcId = fdcId;
        this.description = description;
        this.dataType = dataType;
        this.gtinUpc = gtinUpc;
        this.publishedDate = publishedDate;
        this.brandOwner = brandOwner;
        this.ingridients = ingridients;
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

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getGtinUpc() {
        return gtinUpc;
    }

    public void setGtinUpc(String gtinUpc) {
        this.gtinUpc = gtinUpc;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getBrandOwner() {
        return brandOwner;
    }

    public void setBrandOwner(String brandOwner) {
        this.brandOwner = brandOwner;
    }

    public List<String> getIngridients() {
        return ingridients;
    }

    public void setIngridients(List<String> ingridients) {
        this.ingridients = ingridients;
    }

    public List<FoodNutrients> getFoodNutrients() {
        return foodNutrients;
    }

    public void setFoodNutrients(List<FoodNutrients> foodNutrients) {
        this.foodNutrients = foodNutrients;
    }

    @Override
    public String toString() {
        return "Foods{" +
                "fdcId=" + fdcId +
                ", description='" + description + '\'' +
                ", dataType='" + dataType + '\'' +
                ", gtinUpc='" + gtinUpc + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", brandOwner='" + brandOwner + '\'' +
                ", ingridients=" + ingridients +
                ", foodNutrients=" + foodNutrients +
                '}';
    }
}