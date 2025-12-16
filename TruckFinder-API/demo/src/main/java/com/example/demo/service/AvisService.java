package com.example.demo.service;

import com.example.demo.model.Avis;
import com.example.demo.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AvisService {

    @Autowired
    private AvisRepository avisRepository;

    public Avis ajouterAvis(Avis avis) {
        return avisRepository.save(avis);
    }

    public List<Avis> obtenirAvisParFoodtruck(Integer idFoodtruck) {
        return avisRepository.findByFoodtruck_Id(idFoodtruck);
    }
}
