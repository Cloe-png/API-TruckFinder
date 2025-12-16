package com.example.demo.controller;

import com.example.demo.model.Utilisateur;
import com.example.demo.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/inscrire")
    public Utilisateur inscrire(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.inscrire(utilisateur);
    }

    @PostMapping("/connexion")
    public Optional<Utilisateur> seConnecter(@RequestParam String email, @RequestParam String motDePasse) {
        return utilisateurService.seConnecter(email, motDePasse);
    }
}
