package com.karolk.service;

import com.karolk.repository.FoodsNutrientsRepository;
import com.karolk.repository.FoodsRepository;
import com.karolk.repository.NutrientsRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodsNutrientsService {
    private FoodsRepository foodsRepository;
    private NutrientsRepository nutrientsRepository;
    private FoodsNutrientsRepository foodsNutrientsRepository;

    public FoodsNutrientsService(FoodsRepository foodsRepository,
                                 NutrientsRepository nutrientsRepository,
                                 FoodsNutrientsRepository foodsNutrientsRepository) {
        this.foodsRepository = foodsRepository;
        this.nutrientsRepository = nutrientsRepository;
        this.foodsNutrientsRepository = foodsNutrientsRepository;
    }
}
