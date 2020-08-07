package com.karolk.controller.rest;

import com.karolk.api.model.FoodsApi;
import com.karolk.dto.FoodEntryDto;
import com.karolk.service.FoodEntryService;
import com.karolk.service.FoodProductApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/foodEntry")
public class FoodEntryControllerRest {
    private FoodEntryService foodEntryService;
    private FoodProductApiService foodProductApi;

    public FoodEntryControllerRest(FoodEntryService foodEntryService,
                                   FoodProductApiService foodProductApi) {
        this.foodEntryService = foodEntryService;
        this.foodProductApi = foodProductApi;
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
        List<FoodsApi> foodsApiList = foodProductApi.getFoodsInfoFromApi(foodEntryDto.getFoodId()); // FoodId is the fdcId taken from FoodsDto received by the client.
        // Get Nutrients as key pair values
        // convert foodApiList to Foods entity
        // save FoodsEntity in db
        //Save nutrients in the FoodNutrients Entity having the Foods entity and its id
        // Save foodEntryDto into db
        FoodEntryDto createdFoodEntry = foodEntryService.createFoodEntry(foodEntryDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(createdFoodEntry.getId())
                .toUri();
        return ResponseEntity.created(uri).body(createdFoodEntry);
    }
}
