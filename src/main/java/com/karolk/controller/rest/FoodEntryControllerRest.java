package com.karolk.controller.rest;

import com.karolk.service.FoodEntryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/foodEntry")
public class FoodEntryControllerRest {
    private FoodEntryService foodEntryService;

    public FoodEntryControllerRest(FoodEntryService foodEntryService) {
        this.foodEntryService = foodEntryService;
    }
}
