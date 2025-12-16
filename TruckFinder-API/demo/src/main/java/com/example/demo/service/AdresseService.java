package com.example.demo.service;

import com.example.demo.model.Adresse;
import com.example.demo.model.Foodtruck;
import com.example.demo.repository.AdresseRepository;
import com.example.demo.repository.FoodtruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdresseService {

    @Autowired
    private AdresseRepository adresseRepository;

    @Autowired
    private FoodtruckRepository foodtruckRepository;

    public Adresse ajouterAdresse(Integer idFoodtruck, Adresse adresse) {
        Foodtruck foodtruck = foodtruckRepository.findById(idFoodtruck).orElseThrow(() -> new RuntimeException("Foodtruck non trouvé"));
        adresse.setFoodtruck(foodtruck);
        if (adresse.getEstActuelle()) {
            List<Adresse> adresses = adresseRepository.findByFoodtruck_Id(idFoodtruck);
            adresses.forEach(a -> a.setEstActuelle(false));
            adresseRepository.saveAll(adresses);
        }
        return adresseRepository.save(adresse);
    }

    public List<Adresse> obtenirAdresses(Integer idFoodtruck) {
        return adresseRepository.findByFoodtruck_Id(idFoodtruck);
    }

    public Adresse obtenirAdresseActuelle(Integer idFoodtruck) {
        List<Adresse> adressesActuelles = adresseRepository.findByFoodtruck_IdAndEstActuelle(idFoodtruck, true);
        return adressesActuelles.isEmpty() ? null : adressesActuelles.get(0);
    }
}
