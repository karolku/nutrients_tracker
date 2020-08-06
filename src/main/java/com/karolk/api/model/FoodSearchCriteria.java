package com.karolk.api.model;

public class FoodSearchCriteria {
    private String query;
    private String generalSearchInput;
    private int pageNumber;
    private boolean requireAllWords;

    public FoodSearchCriteria() {
    }

    public FoodSearchCriteria(String query, String generalSearchInput,
                              int pageNumber, boolean requireAllWords) {
        this.query = query;
        this.generalSearchInput = generalSearchInput;
        this.pageNumber = pageNumber;
        this.requireAllWords = requireAllWords;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getGeneralSearchInput() {
        return generalSearchInput;
    }

    public void setGeneralSearchInput(String generalSearchInput) {
        this.generalSearchInput = generalSearchInput;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public boolean isRequireAllWords() {
        return requireAllWords;
    }

    public void setRequireAllWords(boolean requireAllWords) {
        this.requireAllWords = requireAllWords;
    }

    @Override
    public String toString() {
        return "FoodSearchCriteria{" +
                "query='" + query + '\'' +
                ", generalSearchInput='" + generalSearchInput + '\'' +
                ", pageNumber=" + pageNumber +
                ", requireAllWords=" + requireAllWords +
                '}';
    }
}
