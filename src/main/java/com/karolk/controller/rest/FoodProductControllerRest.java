package com.karolk.controller.rest;

import com.karolk.api.model.FoodsApi;
import com.karolk.service.FoodProductApiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usda")
public class FoodProductControllerRest {
    private FoodProductApiService getFoodProductModelService;

    public FoodProductControllerRest(FoodProductApiService getFoodService){
        this.getFoodProductModelService = getFoodService;
    }

    @GetMapping(path = "/foods/{fdcId}")
    public FoodsApi getOneFoodInfoFromApi(@PathVariable("fdcId") Long fdcId){
        FoodsApi foodsList = getFoodProductModelService.getOneFoodInfoFromApi(fdcId);
        return foodsList;
    }
}
