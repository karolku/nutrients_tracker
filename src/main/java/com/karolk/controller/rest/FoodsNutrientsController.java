package com.karolk.controller.rest;

import com.karolk.dto.FoodEntryDto;
import com.karolk.dto.FoodsNutrientsDto;
import com.karolk.dto.NutrientsConsumed;
import com.karolk.service.FoodsNutrientsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/foodsNutrients")
public class FoodsNutrientsController {
    private FoodsNutrientsService foodsNutrientsService;

    public FoodsNutrientsController(FoodsNutrientsService foodsNutrientsService) {
        this.foodsNutrientsService = foodsNutrientsService;
    }

    @GetMapping
    public List<FoodsNutrientsDto> findAllFoodsNutrients() {
        return foodsNutrientsService.findAllFoodsNutrients();
    }

    @GetMapping("/user/{userId}/date/{date}")
    public Map findFoodNutrientsForFoodEntry(@PathVariable Long userId, @PathVariable String date) {
        return foodsNutrientsService.findFoodsNutrientsForFoodEntry(userId, date);
    }

//    @GetMapping("calories/user/{userId}/date/{date}")
//    public ResponseEntity<NutrientsConsumed> findCaloriesConsumedInADay(@PathVariable Long userId, @PathVariable String date) {
//        NutrientsConsumed nutrientsConsumed = foodsNutrientsService.findCaloriesConsumedInADay(userId, date, );
//        return ResponseEntity.ok().body(nutrientsConsumed);
//    }
}
