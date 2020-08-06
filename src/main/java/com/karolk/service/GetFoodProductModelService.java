package com.karolk.service;

import com.karolk.api.model.FoodsApi;
import com.karolk.api.model.FoodProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GetFoodProductModelService {

    @Value("${api.key}")
    private String apiKey;

    private RestTemplate restTemplate;

    @Autowired
    public GetFoodProductModelService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<FoodsApi> getFoodsInfoFromApi(Long fdcId){
        FoodProduct foodProduct = restTemplate.
                getForObject("https://api.nal.usda.gov/fdc/v1/foods/search?query=" +
                        fdcId + "&dataType=Branded&pageSize=25&pageNumber=1&api_key=" + "CzUj0Hv2GnZ0RIyoL8iKGHuix4QLpR4Te4w3hpMv",
                FoodProduct.class);
        List<FoodsApi> foodsApiList = foodProduct.getFoods();
        return foodsApiList;
    }
}
