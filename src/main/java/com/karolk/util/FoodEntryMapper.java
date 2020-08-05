package com.karolk.util;

import com.karolk.dto.FoodEntryDto;
import com.karolk.model.FoodEntry;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodEntryMapper {

    FoodEntryMapper INSTANCE = Mappers.getMapper(FoodEntryMapper.class);

    FoodEntryDto convertFoodEntryToDto(FoodEntry foodEntry);

    FoodEntry convertFoodEntryDtoToFoodEntryEntity(FoodEntryDto foodEntryDto);
}
