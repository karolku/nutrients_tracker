package com.karolk.service;

import com.karolk.api.model.FoodsApi;
import com.karolk.api.model.NutrientsApi;
import com.karolk.dto.FoodsNutrientsDto;
import com.karolk.exception.InvalidFoodsNutrientsException;
import com.karolk.model.Foods;
import com.karolk.model.FoodsNutrients;
import com.karolk.model.Nutrients;
import com.karolk.repository.FoodsNutrientsRepository;
import com.karolk.repository.FoodsRepository;
import com.karolk.repository.NutrientsRepository;
import com.karolk.util.FoodsMapper;
import com.karolk.util.FoodsNutrientsMapper;
import com.karolk.util.NutrientsMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    /*
     There will be rest template getting a particular food item from api
     1. This method will consume will have two parameters, foods and nutrients from the rest template
     2. Foods and nutrients will be save to their respective tables
     3. foodsNutrient will take foods and nutrients objects and then will be saved with foodsnutrientRepository.
     4. Dont have to and convert foodsNutrients to Dto since then user will not have objects of FoodId and Nutrients.
     */
    public List<FoodsNutrientsDto> saveFoodNutrients(List<NutrientsApi> nutrientsApiList, Foods foods) {
        List<FoodsNutrientsDto> savedFoodNutrientsList = new ArrayList<>();
        FoodsNutrients foodsNutrients = new FoodsNutrients();
        FoodsNutrients createdFoodNutrients = null;
        for(NutrientsApi nutrient : nutrientsApiList) {
            Nutrients nutrientEntity = NutrientsMapper.INSTANCE.convertNutrientsApiToEntity(nutrient);
            foodsNutrients.setFoods(foods);
            foodsNutrients.setNutrients(nutrientEntity);
            createdFoodNutrients = foodsNutrientsRepository.save(foodsNutrients);
            savedFoodNutrientsList.add(FoodsNutrientsMapper.INSTANCE.convertEntityToDto(createdFoodNutrients));
        }
        return savedFoodNutrientsList;
    }
}
