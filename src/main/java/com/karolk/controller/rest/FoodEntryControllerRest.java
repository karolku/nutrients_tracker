package com.karolk.controller.rest;

import com.karolk.api.model.FoodsApi;
import com.karolk.api.model.NutrientsApi;
import com.karolk.dto.FoodEntryDto;
import com.karolk.dto.FoodsNutrientsDto;
import com.karolk.exception.InvalidFoodsException;
import com.karolk.model.FoodEntry;
import com.karolk.model.Foods;
import com.karolk.model.Nutrients;
import com.karolk.service.*;
import com.karolk.util.FoodEntryMapper;
import com.karolk.util.FoodsMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/foodEntry")
public class FoodEntryControllerRest {
    private FoodEntryService foodEntryService;
    private FoodProductApiService foodProductApi;
    private FoodsNutrientsService foodsNutrientsService;
    private FoodsService foodsService;
    private NutrientsService nutrientsService;

    public FoodEntryControllerRest(FoodEntryService foodEntryService, FoodProductApiService foodProductApi,
                                   FoodsNutrientsService foodsNutrientsService, FoodsService foodsService,
                                   NutrientsService nutrientsService) {
        this.foodEntryService = foodEntryService;
        this.foodProductApi = foodProductApi;
        this.foodsNutrientsService = foodsNutrientsService;
        this.foodsService = foodsService;
        this.nutrientsService = nutrientsService;
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
        List<NutrientsApi> nutrientsApiList = foodsApi.getFoodNutrients();

        Foods foodsEntity = FoodsMapper.INSTANCE.convertFoodsApiToEntity(foodsApi);
        Foods savedFood = null;
        try {
            savedFood = foodsService.save(foodsEntity);
        } catch (InvalidFoodsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        FoodEntry createdFoodEntry = foodEntryService.createFoodEntry(foodEntryDto, savedFood);
        List<FoodsNutrientsDto> foodsNutrientsDto = foodsNutrientsService.saveFoodNutrients(nutrientsApiList, savedFood, createdFoodEntry);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(createdFoodEntry.getId())
                .toUri();
        FoodEntryDto foodEntryDtoCreated = FoodEntryMapper.INSTANCE.convertFoodEntryEntityToDto(createdFoodEntry);
        foodEntryDtoCreated.setFoodInfo(savedFood);
        return ResponseEntity.created(uri).body(foodEntryDtoCreated);
    }

    @PutMapping("/{foodEntryId}")
    public ResponseEntity<FoodEntryDto> update(@PathVariable Long foodEntryId, @RequestBody FoodEntryDto foodEntryDto) {
        if(!(foodEntryId.equals(foodEntryDto.getId())))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The provided id needs to be the same as the provided user id");
        FoodEntryDto updatedFoodEntry = foodEntryService.update(foodEntryDto);
        return ResponseEntity.ok(updatedFoodEntry);
    }
}
