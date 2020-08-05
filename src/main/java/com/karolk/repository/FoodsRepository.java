package com.karolk.repository;

import com.karolk.model.Foods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodsRepository extends JpaRepository<Foods, Long> {
    Optional<Foods> findByFdcId(Long fdcId);
}

