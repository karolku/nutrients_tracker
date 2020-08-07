package com.karolk.util;

import com.karolk.api.model.FoodsApi;
import com.karolk.dto.FoodsDto;
import com.karolk.model.Foods;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses= NutrientsMapper.class,
        componentModel="spring")
public interface FoodsMapper {

    FoodsMapper INSTANCE = Mappers.getMapper(FoodsMapper.class);

    FoodsDto convertEntityFoodsToDto(Foods foods);

    Foods convertFoodsDtoToEntityFoods(FoodsDto foodsDto);

    Foods convertFoodsApiToEntity(FoodsApi foodsApi);
}
