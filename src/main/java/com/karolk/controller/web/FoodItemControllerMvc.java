package com.karolk.controller.web;

import com.karolk.model.FoodItem;
import com.karolk.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/fooditems")
public class FoodItemControllerMvc {

    private FoodItemRepository foodItemRepository;

    @Autowired
    public FoodItemControllerMvc(FoodItemRepository foodItemRepository){
        this.foodItemRepository = foodItemRepository;
    }

    @GetMapping
    public String listFoodItems(Model model){
        List<FoodItem> foodItems = foodItemRepository.findAll();
        model.addAttribute("foodItemsList", foodItems);
        return "foodlist";
    }

    @PostMapping
    public String addFoodItem(@ModelAttribute FoodItem foodItemModel, RedirectAttributes redirectAttributes){
        foodItemRepository.save(foodItemModel);
        redirectAttributes.addFlashAttribute("messageFoodItemAdded", "Food item has been added successfully.");
        return "redirect:/";
    }
}
