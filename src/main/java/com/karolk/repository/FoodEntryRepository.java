package com.karolk.repository;

import com.karolk.model.FoodEntry;
import com.karolk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FoodEntryRepository extends JpaRepository<FoodEntry, Long> {
    List<FoodEntry> findFoodEntriesByUserId(User userId);
    List<FoodEntry> findFoodEntriesByUserIdAndDateOfFoodEntry(User userId, Date foodEntryDate);
}
