package com.karolk.controller.rest;

import com.karolk.dto.FoodEntryDto;
import com.karolk.model.FoodEntry;
import com.karolk.service.FoodEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/foodEntry")
public class FoodEntryControllerRest {
    private FoodEntryService foodEntryService;

    public FoodEntryControllerRest(FoodEntryService foodEntryService) {
        this.foodEntryService = foodEntryService;
    }

    @GetMapping()
    public List<FoodEntryDto> findAllFoodEntries() {
        return foodEntryService.findAllFoodEntries();
    }

    public ResponseEntity<FoodEntryDto> save(@RequestBody FoodEntryDto foodEntryDto) {
        if(foodEntryDto.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The object cannot have already defined id");
        FoodEntryDto savedFoodEntry = foodEntryService.save(foodEntryDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedFoodEntry.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedFoodEntry);
    }
}
