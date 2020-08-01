package com.karolk.model;

import java.sql.Date;

public class UserFoods {

    private Long id;
    private User user;
    private Foods foods;
    private Date date;
    private double amountOfServing; // all data will be provided per 100 grams. so amount of 1 = 100 grams
    private String servingType;
    private String mealTime;

}
