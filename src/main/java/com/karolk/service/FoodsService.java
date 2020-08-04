package com.karolk.service;

import com.karolk.dto.FoodsDto;
import com.karolk.repository.FoodsRepository;
import com.karolk.util.FoodsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodsService {
    private FoodsRepository foodsRepository;

    public FoodsService(FoodsRepository foodsRepository) {
        this.foodsRepository = foodsRepository;
    }

    public List<FoodsDto> findAllFoods() {
        return foodsRepository.findAll()
                .stream()
                .map(FoodsMapper.INSTANCE::convertEntityFoodsToDto)
                .collect(Collectors.toList());
    }


}
