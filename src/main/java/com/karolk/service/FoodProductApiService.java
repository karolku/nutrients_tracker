package com.karolk.service;

import com.karolk.api.model.FoodsApi;
import com.karolk.api.model.FoodProduct;
import com.karolk.exception.InvalidFoodProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodProductApiService {

    private String apiKey = "CzUj0Hv2GnZ0RIyoL8iKGHuix4QLpR4Te4w3hpMv";
    private RestTemplate restTemplate;

    @Autowired
    public FoodProductApiService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<FoodsApi> getFoodsInfoFromApi(Long fdcId){
        FoodProduct foodProduct = restTemplate.
                getForObject("https://api.nal.usda.gov/fdc/v1/foods/search?query=" +
                        fdcId + "&dataType=Branded&pageSize=25&pageNumber=1&api_key=" + apiKey,
                FoodProduct.class);
        List<FoodsApi> foodsApiList = foodProduct.getFoods();
        return foodsApiList;
    }

    public FoodsApi getOneFoodInfoFromApi(Long fdcId){
        FoodProduct foodProduct = restTemplate.
                getForObject("https://api.nal.usda.gov/fdc/v1/foods/search?query=" +
                                fdcId + "&dataType=Branded&pageSize=25&pageNumber=1&api_key=" + apiKey,
                        FoodProduct.class);

        FoodsApi foodsApi = null;
        if(isOnlyOneFoodItem(foodProduct))
            foodsApi = foodProduct.getFoods().get(0);
        else
            throw new InvalidFoodProductException("There are more than one foods product under this fdcId: " + fdcId);
        return foodsApi;
    }

    private boolean isOnlyOneFoodItem(FoodProduct foodProduct){
        return foodProduct.getFoods().size() == 1 ? true : false;
    }
}
