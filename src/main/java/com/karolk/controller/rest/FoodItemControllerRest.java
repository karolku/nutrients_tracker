package com.karolk.controller.rest;

import com.karolk.model.FoodItem;
import com.karolk.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fooditems")
public class FoodItemControllerRest {

    private FoodItemRepository foodItemRepository;

    @Autowired
    public FoodItemControllerRest(FoodItemRepository foodItemRepository){
        this.foodItemRepository = foodItemRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FoodItem> getFoodItems(@RequestParam(defaultValue = "name") String orderBy){
        List<FoodItem> foodItems = foodItemRepository.findAll();
        return foodItems;
    }
}
