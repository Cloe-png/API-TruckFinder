package com.example.demo.service;

import com.example.demo.model.Demande;
import com.example.demo.repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;

    public Demande ajouterDemande(Demande demande) {
        return demandeRepository.save(demande);
    }

    public List<Demande> obtenirDemandesParFoodtruck(Integer idFoodtruck) {
        return demandeRepository.findByFoodtruck_Id(idFoodtruck);
    }
}
