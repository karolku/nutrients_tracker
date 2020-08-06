package com.karolk.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class Nutrients {

    private Long id;
    private long nutrientId;
    private String nutrientName;
    private String nutrientNumber;
    private String unitName;
    private String derivationCode;
    private String derivationDescription;
    private double value;

    public Nutrients() {
    }

    public Nutrients(long nutrientId, String nutrientName, String nutrientNumber,
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

    public long getNutrientId() {
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
        Nutrients that = (Nutrients) o;
        return nutrientId == that.nutrientId &&
                Double.compare(that.value, value) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(nutrientName, that.nutrientName) &&
                Objects.equals(nutrientNumber, that.nutrientNumber) &&
                Objects.equals(unitName, that.unitName) &&
                Objects.equals(derivationCode, that.derivationCode) &&
                Objects.equals(derivationDescription, that.derivationDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nutrientId, nutrientName, nutrientNumber, unitName,
                derivationCode, derivationDescription, value);
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
