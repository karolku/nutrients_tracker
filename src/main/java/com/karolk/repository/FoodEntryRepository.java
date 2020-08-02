package com.karolk.repository;

import com.karolk.model.FoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodEntryRepository extends JpaRepository<FoodEntry, Long> {
}
