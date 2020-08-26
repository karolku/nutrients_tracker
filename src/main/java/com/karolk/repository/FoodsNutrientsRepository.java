package com.karolk.repository;

import com.karolk.model.FoodEntry;
import com.karolk.model.FoodsNutrients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodsNutrientsRepository extends JpaRepository<FoodsNutrients, Long> {
    List<FoodsNutrients> findFoodsNutrientsByFoodEntry(FoodEntry foodEntry);
}
