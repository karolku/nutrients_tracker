package com.karolk.service;

import com.karolk.dto.FoodsNutrientsDto;
import com.karolk.repository.FoodsNutrientsRepository;
import com.karolk.repository.FoodsRepository;
import com.karolk.repository.NutrientsRepository;
import com.karolk.util.FoodsNutrientsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<FoodsNutrientsDto> findAllFoodsNutrients() {
        return foodsNutrientsRepository.findAll()
                .stream()
                .map(FoodsNutrientsMapper.INSTANCE::convertEntityToDto)
                .collect(Collectors.toList());
    }
}
