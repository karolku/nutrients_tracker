package com.karolk.repository;

import com.karolk.model.FoodNutrients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodNutrientsRepository extends JpaRepository<FoodNutrients, Long> {
}
