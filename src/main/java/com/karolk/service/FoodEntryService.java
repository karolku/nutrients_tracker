package com.karolk.service;

import com.karolk.dto.FoodEntryDto;
import com.karolk.exception.InvalidFoodEntryException;
import com.karolk.exception.InvalidFoodsException;
import com.karolk.exception.InvalidUserException;
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

    public List<FoodEntryDto> findFoodEntriesByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);

        return foodEntryRepository.findFoodEntriesByUserId(user.orElseThrow(() ->
                new InvalidFoodEntryException("Food entry with this user does not exist.")))
                .stream()
                .map(FoodEntryMapper.INSTANCE::convertFoodEntryEntityToDto)
                .collect(Collectors.toList());
    }

    public FoodEntry createFoodEntry(FoodEntryDto foodEntryDto, Foods foods) {
        Optional<User> user = userRepository.findById(foodEntryDto.getUserId());
        FoodEntry foodEntry = new FoodEntry();
        foodEntry.setUserId(user.orElseThrow(() ->
                new InvalidUserException("User with this id does not exist.")));
        foodEntry.setFoodId(foods);
        foodEntry.setAmountOfServing(foodEntryDto.getAmountOfServing());
        foodEntry.setMealTime(foodEntryDto.getMealTime());
        foodEntry.setServingType(foodEntryDto.getServingType());
        foodEntry.setDateOfFoodEntry(foodEntryDto.getDateOfFoodEntry());
        FoodEntry createdFoodEntry = foodEntryRepository.save(foodEntry);
        return createdFoodEntry;
    }

    public FoodEntryDto update(FoodEntryDto foodEntryDto) {
        Optional<FoodEntry> foodEntryEntity = foodEntryRepository.findById(foodEntryDto.getId());
        foodEntryEntity.ifPresent((foodEntry -> {
            if(!(foodEntry.getId().equals(foodEntryDto.getId())))
                throw new InvalidFoodEntryException("FoodEntry with the given id does not exist.");
        }));
        Optional<Foods> foods = foodsRepository.findById(foodEntryDto.getFoodId());
        Foods foodsEntity = foods.orElseThrow(() ->
            { throw new InvalidFoodsException("Food with the id does not exist.");});
        FoodEntry foodEntryUpdated = createFoodEntry(foodEntryDto, foodsEntity);
        return FoodEntryMapper.INSTANCE.convertFoodEntryEntityToDto(foodEntryUpdated);
    }
}
