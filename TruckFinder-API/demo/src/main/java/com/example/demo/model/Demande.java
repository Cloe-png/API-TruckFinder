package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "demandesinscription")
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_foodtruck", nullable = false)
    private Foodtruck foodtruck;

    @Column(name = "date_demande")
    private LocalDateTime dateCreation = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Foodtruck.Statut statut = Foodtruck.Statut.EN_ATTENTE;

    @Column(name = "commentaire_admin", columnDefinition = "TEXT")
    private String commentaire;

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Foodtruck getFoodtruck() {
        return foodtruck;
    }

    public void setFoodtruck(Foodtruck foodtruck) {
        this.foodtruck = foodtruck;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Foodtruck.Statut getStatut() {
        return statut;
    }

    public void setStatut(Foodtruck.Statut statut) {
        this.statut = statut;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
