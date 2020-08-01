package com.karolk.util;

import com.karolk.dto.FoodsDto;
import com.karolk.model.Foods;
import org.mapstruct.Mapper;

@Mapper(uses=FoodNutrientsMapper.class)
public interface FoodsMapper {

    FoodsDto foodsToDto(Foods foods);
}
