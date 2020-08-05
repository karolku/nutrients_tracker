package com.karolk.service;

import com.karolk.dto.FoodEntryDto;
import com.karolk.exception.InvalidFoodEntryException;
import com.karolk.model.FoodEntry;
import com.karolk.model.Foods;
import com.karolk.model.User;
import com.karolk.repository.FoodEntryRepository;
import com.karolk.repository.FoodsRepository;
import com.karolk.repository.UserRepository;
import com.karolk.util.FoodEntryMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodEntryService {
    FoodEntryRepository foodEntryRepository;
    UserRepository userRepository;
    FoodsRepository foodsRepository;

    public FoodEntryService(FoodEntryRepository foodEntryRepository,
                            UserRepository userRepository,
                            FoodsRepository foodsRepository) {
        this.foodEntryRepository = foodEntryRepository;
        this.userRepository = userRepository;
        this.foodsRepository = foodsRepository;
    }

    public List<FoodEntryDto> findAllFoodEntries() {
        return foodEntryRepository.findAll()
                .stream()
                .map(FoodEntryMapper.INSTANCE::convertFoodEntryEntityToDto)
                .collect(Collectors.toList());
    }

    public FoodEntryDto createFoodEntry(FoodEntryDto foodEntryDto) {
        Optional<User> user = userRepository.findById(foodEntryDto.getUserId());
        Optional<Foods> foods = foodsRepository.findByFdcId(foodEntryDto.getFdcId());
        FoodEntry foodEntry = new FoodEntry();
        foodEntry.setUserId(user.orElseThrow(() ->
                new InvalidFoodEntryException("User with this id does not exist.")));
        foodEntry.setFdcId(foods.orElseThrow(() ->
                new InvalidFoodEntryException("Food with this fdcId does not exist.")));
        foodEntry.setAmountOfServing(foodEntryDto.getAmountOfServing());
        foodEntry.setMealTime(foodEntryDto.getMealTime());
        foodEntry.setServingType(foodEntryDto.getServingType());
        foodEntry.setDateOfFoodEntry(foodEntryDto.getDateOfFoodEntry());
        FoodEntry createdFoodEntry = foodEntryRepository.save(foodEntry);
        return FoodEntryMapper.INSTANCE.convertFoodEntryEntityToDto(createdFoodEntry);
    }
}
