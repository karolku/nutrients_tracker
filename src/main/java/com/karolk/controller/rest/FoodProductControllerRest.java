package com.karolk.controller.rest;

import com.karolk.api.model.FoodsApi;
import com.karolk.service.GetFoodProductModelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usda")
public class FoodProductControllerRest {
    private GetFoodProductModelService getFoodProductModelService;

    public FoodProductControllerRest(GetFoodProductModelService getFoodService){
        this.getFoodProductModelService = getFoodService;
    }

    @GetMapping(path = "/foods/{fdcId}")
    public List<FoodsApi> getFoodsInfoFromApi(@PathVariable("fdcId") Long fdcId){
        List<FoodsApi> foodsList = getFoodProductModelService.getFoodsInfoFromApi(fdcId);
        return foodsList;
    }
}
