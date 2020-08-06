package com.karolk.repository;

import com.karolk.model.FoodsNutrients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodsNutrientsRepository extends JpaRepository<FoodsNutrients, Long> {
}
