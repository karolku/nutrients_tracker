package com.karolk.service;

import com.karolk.api.model.NutrientsApi;
import com.karolk.exception.InvalidNutrientsException;
import com.karolk.model.Nutrients;
import com.karolk.repository.NutrientsRepository;
import com.karolk.util.NutrientsMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NutrientsService {
    private NutrientsRepository nutrientsRepository;

    public NutrientsService(NutrientsRepository nutrientsRepository) {
        this.nutrientsRepository = nutrientsRepository;
    }

    public List<Nutrients> saveNutrients(List<NutrientsApi> nutrientsApiList) {
        List<Nutrients> nutrientsSaved = new ArrayList<>();
        Optional<Nutrients> nutrientFromDb = null;
        List<Nutrients> nutrientsEntityList = nutrientsApiList.stream()
                .map(NutrientsMapper.INSTANCE::convertNutrientsApiToEntity)
                .collect(Collectors.toList());
        for(Nutrients nutrient : nutrientsEntityList){
            if(!(nutrientsRepository.existsByNutrientId(nutrient.getNutrientId())))
                nutrientsSaved.add(nutrientsRepository.save(nutrient));
//            else {
//                nutrientFromDb = nutrientsRepository.findByNutrientId(nutrient.getNutrientId());
//                nutrientsSaved.add(nutrientFromDb.orElseThrow(() ->
//                {throw new InvalidNutrientsException("There is not nutrient with this id.");}));
//            }
        }
        return nutrientsSaved;
    }
}
