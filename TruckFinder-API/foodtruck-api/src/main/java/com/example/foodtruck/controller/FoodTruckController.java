package com.example.foodtruck.controller;

import com.example.foodtruck.model.FoodTruck;
import com.example.foodtruck.repository.FoodTruckRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/foodtrucks")
public class FoodTruckController {
    private final FoodTruckRepository repo;
    public FoodTruckController(FoodTruckRepository repo){this.repo=repo;}

    @GetMapping public List<FoodTruck> all(){return repo.findAll();}

    @GetMapping("/{id}")
    public FoodTruck one(@PathVariable Long id){
        return repo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public List<FoodTruck> byPostal(@RequestParam String postalCode){
        return repo.findByPostalCode(postalCode);
    }

    @GetMapping("/search/active")
    public List<FoodTruck> byPostalActive(@RequestParam String postalCode){
        return repo.findByPostalCodeAndActiveTrue(postalCode);
    }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public FoodTruck create(@RequestBody FoodTruck ft){
        ft.setId(null);
        return repo.save(ft);
    }
}
