package com.example.demo.repository;

import com.example.demo.model.Foodtruck;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FoodtruckRepository extends JpaRepository<Foodtruck, Integer> {
    List<Foodtruck> findByStatut(Foodtruck.Statut statut);
    List<Foodtruck> findByTypeCuisine(String typeCuisine);
    List<Foodtruck> findByAdresseContaining(String adresse);
}
