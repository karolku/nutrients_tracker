package com.karolk.service;

import com.karolk.api.model.NutrientsApi;
import com.karolk.dto.FoodsNutrientsDto;
import com.karolk.exception.InvalidFoodsException;
import com.karolk.exception.InvalidNutrientsException;
import com.karolk.model.FoodEntry;
import com.karolk.model.Foods;
import com.karolk.model.FoodsNutrients;
import com.karolk.model.Nutrients;
import com.karolk.repository.FoodsNutrientsRepository;
import com.karolk.repository.FoodsRepository;
import com.karolk.repository.NutrientsRepository;
import com.karolk.util.FoodsNutrientsMapper;
import com.karolk.util.NutrientsMapper;
import com.karolk.util.Round;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

//    public List<FoodsNutrientsDto> findFoodsNutrientsByFoodEntry() {
//        return foodsNutrientsRepository.findFoodsNutrientsByFoodEntry()
//    }

    public List<FoodsNutrientsDto> saveFoodNutrients(List<NutrientsApi> nutrientsApiList, Foods foods, FoodEntry foodEntry) {
        List<FoodsNutrientsDto> savedFoodNutrientsList = new ArrayList<>();
        Optional<Foods> foodsEntity = foodsRepository.findByFdcId(foods.getFdcId());
        FoodsNutrients foodsNutrients = null;
        FoodsNutrients createdFoodNutrients = null;
        for(NutrientsApi nutrient : nutrientsApiList) {
            foodsNutrients = new FoodsNutrients();
            Nutrients nutrientEntity = NutrientsMapper.INSTANCE.convertNutrientsApiToEntity(nutrient);
            Optional<Nutrients> nutrientFromDb = nutrientsRepository.findByNutrientId(nutrientEntity.getNutrientId());
            foodsNutrients.setFoods(foodsEntity.orElseThrow(() ->
                { throw new InvalidFoodsException("Food with FdcId: " + foods.getId() + " does not exist in the databse.");}));
            foodsNutrients.setNutrients(nutrientFromDb.orElseThrow(() ->
                {throw new InvalidNutrientsException("Nutrient with usda id: " + nutrientEntity.getNutrientId() + " does not exist." );}));
            foodsNutrients.setValue(Round.roundToTwoDecimal(nutrientEntity.getValue() * foodEntry.getAmountOfServing()));
            foodsNutrients.setFoodEntry(foodEntry);
            createdFoodNutrients = foodsNutrientsRepository.save(foodsNutrients);
            savedFoodNutrientsList.add(FoodsNutrientsMapper.INSTANCE.convertEntityToDto(createdFoodNutrients));
        }
        return savedFoodNutrientsList;
    }
}
