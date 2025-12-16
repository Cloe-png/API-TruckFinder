package com.example.demo.controller;

import com.example.demo.model.Demande;
import com.example.demo.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandes")
public class DemandeController {

    @Autowired
    private DemandeService demandeService;

    @PostMapping
    public Demande ajouterDemande(@RequestBody Demande demande) {
        return demandeService.ajouterDemande(demande);
    }

    @GetMapping("/foodtruck/{idFoodtruck}")
    public List<Demande> obtenirDemandesParFoodtruck(@PathVariable Integer idFoodtruck) {
        return demandeService.obtenirDemandesParFoodtruck(idFoodtruck);
    }
}
