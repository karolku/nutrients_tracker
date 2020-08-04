package com.karolk.controller.rest;

import com.karolk.dto.FoodsDto;
import com.karolk.model.Foods;
import com.karolk.service.FoodsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodsControllerRest {
    private FoodsService foodsService;

    public FoodsControllerRest(FoodsService foodsService) {
        this.foodsService = foodsService;
    }

    public List<FoodsDto> findAllFoods() {
        return foodsService.findAllFoods();
    }

    @PostMapping()
    public ResponseEntity<FoodsDto> save(@RequestBody FoodsDto foodsDto) {
        if(foodsDto.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The object cannot have already set id.");
        FoodsDto foodsSaved = foodsService.save(foodsDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(foodsDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(foodsSaved);
    }
}
