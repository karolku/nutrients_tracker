package com.karolk.api.model;

import java.util.List;
import java.util.Objects;

public class FoodsApi {

    private Long id;
    private Long fdcId;
    private String description;
    private String dataType;
    private String gtinUpc;
    private String publishedDate;
    private String brandOwner;
    private String ingredients;
    private List<Nutrients> foodNutrients;

    public FoodsApi() {
    }

    public FoodsApi(Long fdcId, String description, String dataType,
                    String gtinUpc, String publishedDate, String brandOwner,
                    String ingredients, List<Nutrients> nutrients) {
        this.fdcId = fdcId;
        this.description = description;
        this.dataType = dataType;
        this.gtinUpc = gtinUpc;
        this.publishedDate = publishedDate;
        this.brandOwner = brandOwner;
        this.ingredients = ingredients;
        this.foodNutrients = nutrients;
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

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Nutrients> getFoodNutrients() {
        return foodNutrients;
    }

    public void setFoodNutrients(List<Nutrients> foodNutrients) {
        this.foodNutrients = foodNutrients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodsApi foodsApi = (FoodsApi) o;
        return Objects.equals(id, foodsApi.id) &&
                Objects.equals(fdcId, foodsApi.fdcId) &&
                Objects.equals(description, foodsApi.description) &&
                Objects.equals(dataType, foodsApi.dataType) &&
                Objects.equals(gtinUpc, foodsApi.gtinUpc) &&
                Objects.equals(publishedDate, foodsApi.publishedDate) &&
                Objects.equals(brandOwner, foodsApi.brandOwner) &&
                Objects.equals(ingredients, foodsApi.ingredients) &&
                Objects.equals(foodNutrients, foodsApi.foodNutrients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fdcId, description, dataType, gtinUpc, publishedDate, brandOwner, ingredients, foodNutrients);
    }

    @Override
    public String toString() {
        return "Foods{" +
                "id=" + id +
                ", fdcId=" + fdcId +
                ", description='" + description + '\'' +
                ", dataType='" + dataType + '\'' +
                ", gtinUpc='" + gtinUpc + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", brandOwner='" + brandOwner + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", nutrients=" + foodNutrients +
                '}';
    }
}
