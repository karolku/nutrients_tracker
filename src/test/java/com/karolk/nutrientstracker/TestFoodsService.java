package com.karolk.nutrientstracker;

import com.karolk.dto.FoodsDto;
import com.karolk.model.Foods;
import com.karolk.repository.FoodsRepository;
import com.karolk.service.FoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestFoodsService {

    @InjectMocks
    FoodsService foodsService;

    @Mock
    FoodsRepository foodsRepository;

    @Test
    public void findAllFoods() {
        List<Foods> foodsList = new ArrayList<>();
        Foods food1 = new Foods(1L,"Food 1", "Type1", "1101",
                "2010-10-10", "CompanyX", "Ingrid1");

        Foods food2 = new Foods(2L,"Food 2", "Type1", "1102",
                "2012-10-10", "CompanyY", "Ingrid2");

        foodsList.add(food1);
        foodsList.add(food2);

        when(foodsRepository.findAll()).thenReturn(foodsList);

        List<FoodsDto> foodsDtosFromService = foodsService.findAllFoods();
        assertEquals(2, foodsList.size());
        verify(foodsRepository, times(1)).findAll();
    }
}
