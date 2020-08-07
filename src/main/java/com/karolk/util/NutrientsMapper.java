package com.karolk.util;

import com.karolk.api.model.NutrientsApi;
import com.karolk.dto.NutrientsDto;
import com.karolk.model.Nutrients;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NutrientsMapper {

    NutrientsMapper INSTANCE = Mappers.getMapper(NutrientsMapper.class);

    NutrientsDto convertNutrientsToDto(Nutrients nutrients);

    Nutrients convertNutrientsApiToEntity(NutrientsApi nutrientsApi);
}
