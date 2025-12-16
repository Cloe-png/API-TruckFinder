package com.example.demo.service;

import com.example.demo.model.Foodtruck;
import com.example.demo.repository.FoodtruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoodtruckService {

    @Autowired
    private FoodtruckRepository foodtruckRepository;

    public List<Foodtruck> trouverFoodtrucksOuverts() {
        return foodtruckRepository.findByStatut(Foodtruck.Statut.APPROUVE);
    }

    public List<Foodtruck> trouverFoodtrucksParAdresse(String adresse) {
        return foodtruckRepository.findByAdresseContaining(adresse);
    }

    public Foodtruck marquerCommeOuvert(Integer idFoodtruck, Boolean estOuvert) {
        Foodtruck foodtruck = foodtruckRepository.findById(idFoodtruck).orElseThrow(() -> new RuntimeException("Foodtruck non trouvé"));
        foodtruck.setEstOuvert(estOuvert);
        return foodtruckRepository.save(foodtruck);
    }
}
