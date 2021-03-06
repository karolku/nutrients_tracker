package com.karolk.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "foods_nutrients")
public class FoodsNutrients implements Serializable {

    private static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foods_nutrients_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id")
    private Foods foods;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nutrient_id")
    private Nutrients nutrients;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_entry_id")
    private FoodEntry foodEntry;

    private Double value;

    public FoodsNutrients() {
    }

    public FoodsNutrients(Foods foods, Nutrients nutrients,
                          double value, FoodEntry foodEntry) {
        this.foods = foods;
        this.nutrients = nutrients;
        this.value = value;
        this.foodEntry = foodEntry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Foods getFoods() {
        return foods;
    }

    public void setFoods(Foods foods) {
        this.foods = foods;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public FoodEntry getFoodEntry() {
        return foodEntry;
    }

    public void setFoodEntry(FoodEntry foodEntry) {
        this.foodEntry = foodEntry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodsNutrients that = (FoodsNutrients) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(foods, that.foods) &&
                Objects.equals(nutrients, that.nutrients) &&
                Objects.equals(value, that.value) &&
                Objects.equals(foodEntry, that.foodEntry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, foods, nutrients, value, foodEntry);
    }

    @Override
    public String toString() {
        return "FoodsNutrients{" +
                "id=" + id +
                ", foods=" + foods +
                ", nutrients=" + nutrients +
                ", value=" + value +
                ", foodEntry=" + foodEntry +
                '}';
    }
}
