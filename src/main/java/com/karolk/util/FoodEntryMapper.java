package com.karolk.util;

import com.karolk.dto.FoodEntryDto;
import com.karolk.model.FoodEntry;
import org.mapstruct.Mapper;

@Mapper
public interface FoodEntryMapper {

    FoodEntryDto foodEntryToDto(FoodEntry foodEntry);
}
