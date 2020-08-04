package com.karolk.controller.rest;

import com.karolk.dto.FoodsDto;
import com.karolk.service.FoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodsControllerRest {
    private FoodsService foodsService;

    public FoodsControllerRest(FoodsService foodsService) {
        this.foodsService = foodsService;
    }

    public List<FoodsDto> findAllFoods() {
        return foodsService.findAllFoods();
    }
}
