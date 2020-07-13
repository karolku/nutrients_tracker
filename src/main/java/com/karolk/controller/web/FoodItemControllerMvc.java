package com.karolk.controller.web;

import com.karolk.model.FoodItem;
import com.karolk.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/fooditems")
public class FoodItemControllerMvc {

    private FoodItemRepository foodItemRepository;

    @Autowired
    public FoodItemControllerMvc(FoodItemRepository foodItemRepository){
        this.foodItemRepository = foodItemRepository;
    }

    @GetMapping
    public String listFoodItems(Model model){
        List<FoodItem> fooditems = foodItemRepository.findAll();
        return "foodlist";
    }

}
