package com.example.demo.service;

import com.example.demo.model.Utilisateur;
import com.example.demo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur inscrire(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Optional<Utilisateur> seConnecter(String email, String motDePasse) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur.isPresent() && utilisateur.get().getMotDePasse().equals(motDePasse)) {
            return utilisateur;
        }
        return Optional.empty();
    }
}
