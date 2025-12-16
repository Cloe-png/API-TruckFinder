package com.example.foodtruck.repository;

import com.example.foodtruck.model.FoodTruck;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FoodTruckRepository extends JpaRepository<FoodTruck,Long>{
    List<FoodTruck> findByPostalCode(String postal);
    List<FoodTruck> findByPostalCodeAndActiveTrue(String postal);
}
