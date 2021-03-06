package com.karolk.controller.rest;

import com.karolk.model.FoodItem;
import com.karolk.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/fooditems")
public class FoodItemControllerRest {

    private FoodItemRepository foodItemRepository;

    @Autowired
    public FoodItemControllerRest(FoodItemRepository foodItemRepository){
        this.foodItemRepository = foodItemRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FoodItem> getFoodItems(@RequestParam(defaultValue = "name") String orderBy){
        List<FoodItem> foodItems = foodItemRepository.findAll();
        if("name".equals(orderBy)){
            foodItems.sort(Comparator.comparing(FoodItem::getName));
        } else if("amount".equals(orderBy)){
            foodItems.sort(Comparator.comparing(FoodItem::getAmount));
        }
        return foodItems;
    }

    @GetMapping(path= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FoodItem> getFoodItem(@PathVariable Long id){
        return foodItemRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public void saveFoodItem(@RequestBody FoodItem foodItem){
        foodItemRepository.save(foodItem);
    }

    @DeleteMapping
    public void deleteFoodItem(@PathVariable long id){
        foodItemRepository.deleteById(id);
    }
}
