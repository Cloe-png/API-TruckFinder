package com.example.demo.repository;

import com.example.demo.model.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AvisRepository extends JpaRepository<Avis, Integer> {
    List<Avis> findByFoodtruck_Id(Integer idFoodtruck);
}
