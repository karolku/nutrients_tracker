package com.karolk.util;

import com.karolk.dto.FoodNutrientsDto;
import com.karolk.model.FoodNutrients;
import org.mapstruct.Mapper;

@Mapper
public interface FoodNutrientsMapper {

    FoodNutrientsDto foodNutrientsToDto(FoodNutrients foodNutrients);
}
