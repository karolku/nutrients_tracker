package com.karolk.repository;

import com.karolk.model.Nutrients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutrientsRepository extends JpaRepository<Nutrients, Long> {
    Nutrients findByNutrientId(Long nutrientId);
}
