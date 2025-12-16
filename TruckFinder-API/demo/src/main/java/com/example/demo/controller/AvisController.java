package com.example.demo.controller;

import com.example.demo.model.Avis;
import com.example.demo.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avis")
public class AvisController {

    @Autowired
    private AvisService avisService;

    @PostMapping
    public Avis ajouterAvis(@RequestBody Avis avis) {
        return avisService.ajouterAvis(avis);
    }

    @GetMapping("/foodtruck/{idFoodtruck}")
    public List<Avis> obtenirAvisParFoodtruck(@PathVariable Integer idFoodtruck) {
        return avisService.obtenirAvisParFoodtruck(idFoodtruck);
    }
}
