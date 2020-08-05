package com.karolk.service;

import com.karolk.repository.FoodEntryRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodEntryService {
    FoodEntryRepository foodEntryRepository;

    public FoodEntryService(FoodEntryRepository foodEntryRepository) {
        this.foodEntryRepository = foodEntryRepository;
    }
}
