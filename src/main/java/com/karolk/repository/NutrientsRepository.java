package com.karolk.repository;

import com.karolk.model.Nutrients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NutrientsRepository extends JpaRepository<Nutrients, Long> {
    Optional<Nutrients> findByNutrientId(Long nutrientId);
    boolean existsByNutrientId(Long nutrientId);
}
