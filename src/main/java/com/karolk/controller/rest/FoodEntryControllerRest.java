package com.karolk.controller.rest;

import com.karolk.api.model.FoodsApi;
import com.karolk.api.model.NutrientsApi;
import com.karolk.dto.FoodEntryDto;
import com.karolk.dto.FoodsNutrientsDto;
import com.karolk.model.Foods;
import com.karolk.model.FoodsNutrients;
import com.karolk.service.FoodEntryService;
import com.karolk.service.FoodProductApiService;
import com.karolk.service.FoodsNutrientsService;
import com.karolk.service.FoodsService;
import com.karolk.util.FoodsMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/foodEntry")
public class FoodEntryControllerRest {
    private FoodEntryService foodEntryService;
    private FoodProductApiService foodProductApi;
    private FoodsNutrientsService foodsNutrientsService;
    private FoodsService foodsService;

    public FoodEntryControllerRest(FoodEntryService foodEntryService,
                                   FoodProductApiService foodProductApi,
                                   FoodsNutrientsService foodsNutrientsService,
                                   FoodsService foodsService) {
        this.foodEntryService = foodEntryService;
        this.foodProductApi = foodProductApi;
        this.foodsNutrientsService = foodsNutrientsService;
        this.foodsService = foodsService;
    }

    @GetMapping()
    public List<FoodEntryDto> findAllFoodEntries() {
        return foodEntryService.findAllFoodEntries();
    }

    @GetMapping(path = "user/{userId}")
    public List<FoodEntryDto> findFoodEntriesByUserId(@PathVariable Long userId) {
        return foodEntryService.findFoodEntriesByUserId(userId);
    }

    @PostMapping()
    public ResponseEntity<FoodEntryDto> saveFoodEntry(@RequestBody FoodEntryDto foodEntryDto) {
        FoodsApi foodsApi = foodProductApi.getOneFoodInfoFromApi(foodEntryDto.getFoodId()); // FoodId is the fdcId taken from FoodsDto received by the client.
        HashMap<Long, Double> nutrientsValues = (HashMap<Long, Double>) foodsNutrientsService.getNutrientsFromFoodsApi(foodsApi);
        List<NutrientsApi> nutrientsApiList = foodsApi.getFoodNutrients();
        Foods foodsEntity = FoodsMapper.INSTANCE.convertFoodsApiToEntity(foodsApi);
        Foods savedFood = foodsService.save(foodsEntity);
        List<FoodsNutrientsDto> foodsNutrientsDto = foodsNutrientsService.saveFoodNutrients(nutrientsApiList, foodsApi);
        FoodEntryDto createdFoodEntry = foodEntryService.createFoodEntry(foodEntryDto, savedFood);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(createdFoodEntry.getId())
                .toUri();
        return ResponseEntity.created(uri).body(createdFoodEntry);
    }
}
