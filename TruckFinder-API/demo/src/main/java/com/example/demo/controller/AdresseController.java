package com.example.demo.controller;

import com.example.demo.model.Adresse;
import com.example.demo.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adresses")
public class AdresseController {

    @Autowired
    private AdresseService adresseService;

    @PostMapping("/{idFoodtruck}")
    public Adresse ajouterAdresse(@PathVariable Integer idFoodtruck, @RequestBody Adresse adresse) {
        return adresseService.ajouterAdresse(idFoodtruck, adresse);
    }

    @GetMapping("/{idFoodtruck}")
    public List<Adresse> obtenirAdresses(@PathVariable Integer idFoodtruck) {
        return adresseService.obtenirAdresses(idFoodtruck);
    }

    @GetMapping("/{idFoodtruck}/actuelle")
    public Adresse obtenirAdresseActuelle(@PathVariable Integer idFoodtruck) {
        return adresseService.obtenirAdresseActuelle(idFoodtruck);
    }
}
