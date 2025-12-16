package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "avis")
public class Avis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Utilisateur client;

    @ManyToOne
    @JoinColumn(name = "id_foodtruck", nullable = false)
    private Foodtruck foodtruck;

    @Column(nullable = false)
    private Integer note;

    @Column(columnDefinition = "TEXT")
    private String commentaire;

    @Column(name = "date_avis")
    private LocalDateTime dateAvis = LocalDateTime.now();

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utilisateur getClient() {
        return client;
    }

    public void setClient(Utilisateur client) {
        this.client = client;
    }

    public Foodtruck getFoodtruck() {
        return foodtruck;
    }

    public void setFoodtruck(Foodtruck foodtruck) {
        this.foodtruck = foodtruck;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public LocalDateTime getDateAvis() {
        return dateAvis;
    }

    public void setDateAvis(LocalDateTime dateAvis) {
        this.dateAvis = dateAvis;
    }
}
