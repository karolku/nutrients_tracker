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
    public List<FoodsApi> getFoodsInfoFromApi(@PathVariable("fdcId") Long fdcId){
        List<FoodsApi> foodsList = getFoodProductModelService.getFoodsInfoFromApi(fdcId);
        return foodsList;
    }
}
