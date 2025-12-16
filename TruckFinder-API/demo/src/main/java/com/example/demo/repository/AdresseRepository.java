package com.example.demo.repository;

import com.example.demo.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
    List<Adresse> findByFoodtruck_Id(Integer idFoodtruck);
    List<Adresse> findByFoodtruck_IdAndEstActuelle(Integer idFoodtruck, Boolean estActuelle);
}
