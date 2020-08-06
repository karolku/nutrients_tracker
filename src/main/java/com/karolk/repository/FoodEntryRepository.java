package com.karolk.repository;

import com.karolk.model.FoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodEntryRepository extends JpaRepository<FoodEntry, Long> {
    List<FoodEntry> findFoodEntriesByUserId(Long userId);
}
