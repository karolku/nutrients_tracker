package com.karolk.service;

import com.karolk.dto.FoodEntryDto;
import com.karolk.model.FoodEntry;
import com.karolk.repository.FoodEntryRepository;
import com.karolk.util.FoodEntryMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodEntryService {
    FoodEntryRepository foodEntryRepository;

    public FoodEntryService(FoodEntryRepository foodEntryRepository) {
        this.foodEntryRepository = foodEntryRepository;
    }

    public List<FoodEntryDto> findAllFoodEntries() {
        return foodEntryRepository.findAll()
                .stream()
                .map(FoodEntryMapper.INSTANCE::convertFoodEntryToDto)
                .collect(Collectors.toList());
    }
}
