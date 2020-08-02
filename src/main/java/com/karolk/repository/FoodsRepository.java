package com.karolk.repository;

import com.karolk.model.Foods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodsRepository extends JpaRepository<Foods, Long> {
}

