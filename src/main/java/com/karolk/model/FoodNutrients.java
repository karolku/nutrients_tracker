package com.karolk.model;

import javax.persistence.*;

@Entity
@Table(name = "food_nutrients")
public class FoodNutrients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_nutrient_id")
    private Long id;

    @Column(name = "nutrient_id")
    private long nutrientId;

    @Column(name = "nutrient_name")
    private String nutrientName;

    @Column(name = "nutrient_number")
    private String nutrientNumber;

    @Column(name = "unit_name")
    private String unitName;

    @Column(name = "derivation_code")
    private String derivationCode;

    @Column(name = "derivation_description")
    private String derivationDescription;

    @Column(name = "value")
    private double value;

    public FoodNutrients() {
    }

    public FoodNutrients(long nutrientId, String nutrientName, String nutrientNumber,
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
