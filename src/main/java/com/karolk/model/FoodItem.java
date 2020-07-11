package com.karolk.model;

import java.io.Serializable;
import java.util.Date;

public class FoodItem implements Serializable {

    //form the oracle documentation about the serialization.
    private static final long serialVersionUID = 42L;

    private long id;
    private String name;
    private float amount;
    private Date date;
    private boolean isBreakfast;
    private boolean isLunch;
    private boolean isDinner;
    private boolean isSnack;

    public FoodItem(){}

    public FoodItem(String name, float amount, Date date, boolean isBreakfast, boolean isLunch, boolean isDinner, boolean isSnack){
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.isBreakfast = isBreakfast;
        this.isLunch = isLunch;
        this.isDinner = isDinner;
        this.isSnack = isSnack;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isBreakfast() {
        return isBreakfast;
    }

    public void setBreakfast(boolean breakfast) {
        isBreakfast = breakfast;
    }

    public boolean isLunch() {
        return isLunch;
    }

    public void setLunch(boolean lunch) {
        isLunch = lunch;
    }

    public boolean isDinner() {
        return isDinner;
    }

    public void setDinner(boolean dinner) {
        isDinner = dinner;
    }

    public boolean isSnack() {
        return isSnack;
    }

    public void setSnack(boolean snack) {
        isSnack = snack;
    }
}
