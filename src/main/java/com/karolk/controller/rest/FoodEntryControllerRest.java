package com.karolk.controller.rest;

import com.karolk.dto.FoodEntryDto;
import com.karolk.service.FoodEntryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/foodEntry")
public class FoodEntryControllerRest {
    private FoodEntryService foodEntryService;

    public FoodEntryControllerRest(FoodEntryService foodEntryService) {
        this.foodEntryService = foodEntryService;
    }

    @GetMapping()
    public List<FoodEntryDto> findAllFoodEntries() {
        return foodEntryService.findAllFoodEntries();
    }
}
