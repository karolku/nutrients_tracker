package com.karolk.controller.rest;

import com.karolk.service.FoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/foods")
public class FoodsControllerRest {
    private FoodsService foodsService;

    public FoodsControllerRest(FoodsService foodsService) {
        this.foodsService = foodsService;
    }
}
