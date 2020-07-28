package com.karolk.model;

public class FoodProduct {

    private FoodSearchCriteria foodSearchCriteria;
    private TotalHits totalHits;
    private int currentPage;
    private int totalPages;
    private List<Foods> foodsList;

    public FoodProduct() {
    }

    public FoodProduct(FoodSearchCriteria foodSearchCriteria, TotalHits totalHits,
                       int currentPage, int totalPages, List<Foods> foodsList) {
        this.foodSearchCriteria = foodSearchCriteria;
        this.totalHits = totalHits;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.foodsList = foodsList;
    }

    public FoodSearchCriteria getFoodSearchCriteria() {
        return foodSearchCriteria;
    }

    public void setFoodSearchCriteria(FoodSearchCriteria foodSearchCriteria) {
        this.foodSearchCriteria = foodSearchCriteria;
    }

    public TotalHits getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(TotalHits totalHits) {
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

    public List<Foods> getFoodsList() {
        return foodsList;
    }

    public void setFoodsList(List<Foods> foodsList) {
        this.foodsList = foodsList;
    }

    @Override
    public String toString() {
        return "FoodProduct{" +
                "foodSearchCriteria=" + foodSearchCriteria +
                ", totalHits=" + totalHits +
                ", currentPage=" + currentPage +
                ", totalPages=" + totalPages +
                ", foodsList=" + foodsList +
                '}';
    }
}
