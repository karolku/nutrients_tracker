package com.karolk.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "food_items")
public class Foods implements Serializable {

    //from the oracle documentation about the serialization.
    private static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;
    private Long fdcId;
    private String description;

    @Column(name = "data_type")
    private String dataType;

    @Column(name= "gtin_upc")
    private String gtinUpc;

    @Column(name = "published_date")
    private String publishedDate;

    @Column(name = "brand_owner")
    private String brandOwner;

    @Column(name = "ingredients")
    @ElementCollection(targetClass = String.class)
    private List<String> ingredients;

    @ManyToMany
    @JoinTable(name = "foods_nutrients")
    private List<FoodNutrients> foodNutrients;

    public Foods() {
    }

    public Foods(Long fdcId, String description, String dataType, String gtinUpc,
                 String publishedDate, String brandOwner, List<String> ingredients,
                 List<FoodNutrients> foodNutrients) {
        this.fdcId = fdcId;
        this.description = description;
        this.dataType = dataType;
        this.gtinUpc = gtinUpc;
        this.publishedDate = publishedDate;
        this.brandOwner = brandOwner;
        this.ingredients = ingredients;
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

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
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
                Objects.equals(ingredients, foods.ingredients) &&
                Objects.equals(foodNutrients, foods.foodNutrients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fdcId, description, dataType, gtinUpc,
                publishedDate, brandOwner, ingredients, foodNutrients);
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
                ", ingridients=" + ingredients +
                ", foodNutrients=" + foodNutrients +
                '}';
    }
}
