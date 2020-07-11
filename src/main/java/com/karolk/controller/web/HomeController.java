package com.karolk.controller.web;

import com.karolk.model.FoodItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("foodItemModel", new FoodItem());
        return "index";
    }
}
