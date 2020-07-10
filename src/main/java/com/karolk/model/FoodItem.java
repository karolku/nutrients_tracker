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

}
