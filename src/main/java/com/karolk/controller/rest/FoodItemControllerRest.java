package com.karolk.controller.rest;

import com.karolk.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fooditems")
public class FoodItemControllerRest {

    private FoodItemRepository foodItemRepository;

    @Autowired
    public FoodItemControllerRest(FoodItemRepository foodItemRepository){
        this.foodItemRepository = foodItemRepository;
    }
}
