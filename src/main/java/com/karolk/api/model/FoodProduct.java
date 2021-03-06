package com.karolk.api.model;

import java.util.List;

public class FoodProduct {

    private FoodSearchCriteria foodSearchCriteria;
    private int totalHits;
    private int currentPage;
    private int totalPages;
    private List<FoodsApi> foods;

    public FoodProduct() {
    }

    public FoodProduct(FoodSearchCriteria foodSearchCriteria, int totalHits,
                       int currentPage, int totalPages, List<FoodsApi> foods) {
        this.foodSearchCriteria = foodSearchCriteria;
        this.totalHits = totalHits;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.foods = foods;
    }

    public FoodSearchCriteria getFoodSearchCriteria() {
        return foodSearchCriteria;
    }

    public void setFoodSearchCriteria(FoodSearchCriteria foodSearchCriteria) {
        this.foodSearchCriteria = foodSearchCriteria;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<FoodsApi> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodsApi> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "FoodProduct{" +
                "foodSearchCriteria=" + foodSearchCriteria +
                ", totalHits=" + totalHits +
                ", currentPage=" + currentPage +
                ", totalPages=" + totalPages +
                ", foodsList=" + foods +
                '}';
    }
}
