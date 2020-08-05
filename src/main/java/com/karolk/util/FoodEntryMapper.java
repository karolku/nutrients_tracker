package com.karolk.util;

import com.karolk.dto.FoodEntryDto;
import com.karolk.model.FoodEntry;
import com.karolk.model.Foods;
import com.karolk.model.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodEntryMapper {
    FoodEntryMapper INSTANCE = Mappers.getMapper(FoodEntryMapper.class);

    FoodEntryDto convertFoodEntryEntityToDto(FoodEntry foodEntry);

    default Long toLongUser(User user) {
        return user.getId();
    }

    default Long toLongFoods(Foods foods) {
        return foods.getFdcId();
    }
}
