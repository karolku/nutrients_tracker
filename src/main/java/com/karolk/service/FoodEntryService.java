package com.karolk.service;

import com.karolk.dto.FoodEntryDto;
import com.karolk.model.FoodEntry;
import com.karolk.repository.FoodEntryRepository;
import com.karolk.repository.FoodsRepository;
import com.karolk.repository.UserRepository;
import com.karolk.util.FoodEntryMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public FoodEntryDto save(FoodEntryDto foodEntryDto) {
        FoodEntry foodEntry = FoodEntryMapper.INSTANCE.convertFoodEntryDtoToEntity(foodEntryDto);
        FoodEntry savedFoodEntry = foodEntryRepository.save(foodEntry);
        return FoodEntryMapper.INSTANCE.convertFoodEntryEntityToDto(savedFoodEntry);
    }
}
