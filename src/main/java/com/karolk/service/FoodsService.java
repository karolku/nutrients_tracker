package com.karolk.service;

import com.karolk.repository.FoodsRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodsService {
    private FoodsRepository foodsRepository;

    public FoodsService(FoodsRepository foodsRepository) {
        this.foodsRepository = foodsRepository;
    }
}
