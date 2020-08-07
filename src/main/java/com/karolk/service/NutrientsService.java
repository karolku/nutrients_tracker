package com.karolk.service;

import com.karolk.repository.NutrientsRepository;
import org.springframework.stereotype.Service;

@Service
public class NutrientsService {
    private NutrientsRepository nutrientsRepository;

    public NutrientsService(NutrientsRepository nutrientsRepository) {
        this.nutrientsRepository = nutrientsRepository;
    }
}
