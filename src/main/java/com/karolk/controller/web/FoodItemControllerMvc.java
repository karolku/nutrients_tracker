package com.karolk.controller.web;

import com.karolk.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fooditems")
public class FoodItemControllerMvc {

    private FoodItemRepository foodItemRepository;

    @Autowired
    public FoodItemControllerMvc(FoodItemRepository foodItemRepository){
        this.foodItemRepository = foodItemRepository;
    }
}
