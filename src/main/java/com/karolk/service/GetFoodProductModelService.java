package com.karolk.service;

import com.karolk.model.FoodProduct;
import com.karolk.model.Foods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class GetFoodProductModelService {

    @Value("${api.key}")
    private String apiKey;

    private RestTemplate restTemplate;

    @Autowired
    public GetFoodProductModelService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Foods> getFoodsInfoFromApi(Long fdcId){
        FoodProduct foodProduct = restTemplate.
                getForObject("https://api.nal.usda.gov/fdc/v1/foods/search?query=" +
                        fdcId + "&dataType=Branded&pageSize=25&pageNumber=1&api_key=" + apiKey,
                FoodProduct.class);
        List<Foods> foodsList = foodProduct.getFoodsList();
        return foodsList;
    }
}
