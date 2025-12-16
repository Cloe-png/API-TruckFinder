package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "adresses_foodtruck")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_foodtruck", nullable = false)
    private Foodtruck foodtruck;

    @Column(nullable = false, length = 255)
    private String adresse;

    @Column(name = "est_actuelle")
    private Boolean estActuelle = false;

    // Getters et Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Foodtruck getFoodtruck() { return foodtruck; }
    public void setFoodtruck(Foodtruck foodtruck) { this.foodtruck = foodtruck; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public Boolean getEstActuelle() { return estActuelle; }
    public void setEstActuelle(Boolean estActuelle) { this.estActuelle = estActuelle; }
}
