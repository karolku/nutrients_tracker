package com.karolk.util;

import com.karolk.dto.FoodNutrientsDto;
import com.karolk.model.FoodNutrients;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodNutrientsMapper {

    FoodNutrientsMapper INSTANCE = Mappers.getMapper(FoodNutrientsMapper.class);

    FoodNutrientsDto foodNutrientsToDto(FoodNutrients foodNutrients);
}
