package com.karolk.model;

import javax.persistence.Entity;

@Entity
public class FoodNutrients {
    private Long nutrientId;
    private String nutrientName;
    private String nutrientNumber;
    private String unitName;
    private String derivationCode;
    private String derivationDescription;
    private double value;

    public FoodNutrients() {
    }

    public FoodNutrients(Long nutrientId, String nutrientName, String nutrientNumber,
                         String unitName, String derivationCode, String derivationDescription,
                         double value) {
        this.nutrientId = nutrientId;
        this.nutrientName = nutrientName;
        this.nutrientNumber = nutrientNumber;
        this.unitName = unitName;
        this.derivationCode = derivationCode;
        this.derivationDescription = derivationDescription;
        this.value = value;
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

    public String getNutrientNumber() {
        return nutrientNumber;
    }

    public void setNutrientNumber(String nutrientNumber) {
        this.nutrientNumber = nutrientNumber;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getDerivationCode() {
        return derivationCode;
    }

    public void setDerivationCode(String derivationCode) {
        this.derivationCode = derivationCode;
    }

    public String getDerivationDescription() {
        return derivationDescription;
    }

    public void setDerivationDescription(String derivationDescription) {
        this.derivationDescription = derivationDescription;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "FoodNutrients{" +
                "nutrientId=" + nutrientId +
                ", nutrientName='" + nutrientName + '\'' +
                ", nutrientNumber='" + nutrientNumber + '\'' +
                ", unitName='" + unitName + '\'' +
                ", derivationCode='" + derivationCode + '\'' +
                ", derivationDescription='" + derivationDescription + '\'' +
                ", value=" + value +
                '}';
    }
}
