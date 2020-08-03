package com.karolk.util;

import com.karolk.dto.FoodsDto;
import com.karolk.model.Foods;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses=FoodNutrientsMapper.class,
        componentModel="spring")
public interface FoodsMapper {

    FoodsMapper INSTANCE = Mappers.getMapper(FoodsMapper.class);

    FoodsDto convertFoodsToDto(Foods foods);
}
