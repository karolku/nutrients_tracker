package com.karolk.controller.rest;

import com.karolk.dto.FoodEntryDto;
import com.karolk.service.FoodEntryService;
import com.karolk.service.GetFoodProductModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/foodEntry")
public class FoodEntryControllerRest {
    private FoodEntryService foodEntryService;
    private GetFoodProductModelService foodProductApi;

    public FoodEntryControllerRest(FoodEntryService foodEntryService, GetFoodProductModelService foodProductApi) {
        this.foodEntryService = foodEntryService;
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

        FoodEntryDto createdFoodEntry = foodEntryService.createFoodEntry(foodEntryDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdFoodEntry.getId())
                .toUri();
        return ResponseEntity.created(uri).body(createdFoodEntry);
    }
}
