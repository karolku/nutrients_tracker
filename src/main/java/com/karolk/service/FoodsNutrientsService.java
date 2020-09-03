package com.karolk.service;

import com.karolk.api.model.NutrientsApi;
import com.karolk.dto.FoodEntryDto;
import com.karolk.dto.FoodsDto;
import com.karolk.dto.FoodsNutrientsDto;
import com.karolk.dto.NutrientsDto;
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
import org.springframework.http.ResponseEntity;
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
    private FoodEntryService foodEntryService;

    public FoodsNutrientsService(FoodsRepository foodsRepository,
                                 NutrientsRepository nutrientsRepository,
                                 FoodsNutrientsRepository foodsNutrientsRepository,
                                 FoodEntryService foodEntryService) {
        this.foodsRepository = foodsRepository;
        this.nutrientsRepository = nutrientsRepository;
        this.foodsNutrientsRepository = foodsNutrientsRepository;
        this.foodEntryService = foodEntryService;
    }

    public List<FoodsNutrientsDto> findAllFoodsNutrients() {
        return foodsNutrientsRepository.findAll()
                .stream()
                .map(FoodsNutrientsMapper.INSTANCE::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public List<FoodEntryDto> findFoodsNutrientsForFoodEntry(Long userId, String date) {
        List<FoodEntry> foodEntryList = foodEntryService.findFoodEntriesEntityByUserIdAndDate(userId, date);
        List<FoodEntryDto> foodEntryDtoList = foodEntryService.getFoodEntryDtos(foodEntryList);
        List<FoodsNutrients> foodsNutrientsList;
        for(int i = 0; i < foodEntryList.size(); i++) {
            List<NutrientsDto> nutrientsDtoListForOneEntry = new ArrayList<>();
            foodsNutrientsList = foodsNutrientsRepository.findFoodsNutrientsByFoodEntry(foodEntryList.get(i));
            for(int j = 0; j < foodsNutrientsList.size(); j++) {
                 nutrientsDtoListForOneEntry.add(
                         NutrientsMapper.INSTANCE.convertNutrientsToDto(foodsNutrientsList.get(j).getNutrients()));
                 nutrientsDtoListForOneEntry.get(j).setValue(foodsNutrientsList.get(j).getValue());
            }
            foodEntryDtoList.get(i).getFoodInfo().setNutrientsDtoList(nutrientsDtoListForOneEntry);
            System.out.println("Nutrients list from the foodEntryDto");
            foodEntryDtoList.get(i).getFoodInfo().getNutrientsDtoList();
        }
        return foodEntryDtoList;
    }

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

    public Double findCaloriesConsumedInADay(Long userId, String date) {
        List<FoodEntryDto> foodEntryDtoList = findFoodsNutrientsForFoodEntry(userId, date);
        Double caloriesConsumed = (double) 0;
        for(int i = 0; i < foodEntryDtoList.size(); i++) {
            List<NutrientsDto> nutrientsDtoList = foodEntryDtoList.get(i).getFoodInfo().getNutrientsDtoList();
            for(int j = 0; j < nutrientsDtoList.size(); j++) {
                if(nutrientsDtoList.get(j).getNutrientId() == 1008)
                    caloriesConsumed += nutrientsDtoList.get(j).getValue();
            }
        }
        return caloriesConsumed;
    }
}

