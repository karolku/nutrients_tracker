package com.karolk.util;

import com.karolk.dto.FoodsNutrientsDto;
import com.karolk.model.Foods;
import com.karolk.model.FoodsNutrients;
import com.karolk.model.Nutrients;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodsNutrientsMapper {
    FoodsNutrientsMapper INSTANCE = Mappers.getMapper(FoodsNutrientsMapper.class);

    FoodsNutrientsDto convertEntityToDto(FoodsNutrients foodsNutrients);

    default Long toLongFoods(Foods foods) {
        return foods.getId();
    }

    default Long toLongNutrients(Nutrients nutrients) {
        return nutrients.getId();
    }
}

