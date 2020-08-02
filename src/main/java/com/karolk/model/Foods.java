package com.karolk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Entity
public class Foods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foods foods = (Foods) o;
        return Objects.equals(id, foods.id) &&
                Objects.equals(fdcId, foods.fdcId) &&
                Objects.equals(description, foods.description) &&
                Objects.equals(dataType, foods.dataType) &&
                Objects.equals(gtinUpc, foods.gtinUpc) &&
                Objects.equals(publishedDate, foods.publishedDate) &&
                Objects.equals(brandOwner, foods.brandOwner) &&
                Objects.equals(ingridients, foods.ingridients) &&
                Objects.equals(foodNutrients, foods.foodNutrients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fdcId, description, dataType, gtinUpc,
                publishedDate, brandOwner, ingridients, foodNutrients);
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
