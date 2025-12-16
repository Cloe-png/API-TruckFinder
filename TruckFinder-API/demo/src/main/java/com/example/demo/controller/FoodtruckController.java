package com.example.demo.controller;

import com.example.demo.model.Foodtruck;
import com.example.demo.service.FoodtruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foodtrucks")
public class FoodtruckController {

    @Autowired
    private FoodtruckService foodtruckService;

    @GetMapping("/ouverts")
    public List<Foodtruck> trouverFoodtrucksOuverts() {
        return foodtruckService.trouverFoodtrucksOuverts();
    }

    @GetMapping("/adresse/{adresse}")
    public List<Foodtruck> trouverFoodtrucksParAdresse(@PathVariable String adresse) {
        return foodtruckService.trouverFoodtrucksParAdresse(adresse);
    }

    @PutMapping("/{idFoodtruck}/etat")
    public Foodtruck marquerCommeOuvert(@PathVariable Integer idFoodtruck, @RequestParam Boolean estOuvert) {
        return foodtruckService.marquerCommeOuvert(idFoodtruck, estOuvert);
    }
}
