package com.karolk.service;

import com.karolk.dto.FoodsDto;
import com.karolk.exception.InvalidFoodsException;
import com.karolk.model.Foods;
import com.karolk.repository.FoodsRepository;
import com.karolk.util.FoodsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public FoodsDto save(FoodsDto foodsDto) {
        Foods foods = FoodsMapper.INSTANCE.convertFoodsDtoToEntityFoods(foodsDto);
        Foods savedFoods = foodsRepository.save(foods);
        return FoodsMapper.INSTANCE.convertEntityFoodsToDto(savedFoods);
    }

    public Foods save(Foods foods) {
        Foods foodSaved = null;
        Optional<Foods> foodsFromDb = null;
        if(foodsRepository.findByFdcId(foods.getFdcId()).isEmpty())
            foodSaved = foodsRepository.save(foods);
        else {
            foodsFromDb = foodsRepository.findById(foods.getId());
            foodSaved = foodsFromDb.orElseThrow(() -> {
                throw new InvalidFoodsException("Food with this id does not exist in the db.");});
        }
        return foodSaved;
    }
}
