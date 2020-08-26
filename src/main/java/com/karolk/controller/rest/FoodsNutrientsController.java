package com.karolk.controller.rest;

import com.karolk.dto.FoodsNutrientsDto;
import com.karolk.service.FoodsNutrientsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
