package com.karolk.nutrientstracker;

import com.karolk.repository.FoodsRepository;
import com.karolk.service.FoodsService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestFoodsService {

    @InjectMocks
    FoodsService foodsService;

    @Mock
    FoodsRepository foodsRepository;
}
