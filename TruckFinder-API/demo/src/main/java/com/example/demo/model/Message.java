package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Utilisateur client;

    @ManyToOne
    @JoinColumn(name = "id_foodtruck", nullable = false)
    private Foodtruck foodtruck;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contenu;

    @Column(name = "date_envoi")
    private LocalDateTime dateEnvoi = LocalDateTime.now();

    @Column(columnDefinition = "TEXT")
    private String reponse;

    @Column(name = "date_reponse")
    private LocalDateTime dateReponse;

    // Getters et Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Utilisateur getClient() { return client; }
    public void setClient(Utilisateur client) { this.client = client; }
    public Foodtruck getFoodtruck() { return foodtruck; }
    public void setFoodtruck(Foodtruck foodtruck) { this.foodtruck = foodtruck; }
    public String getContenu() { return contenu; }
    public void setContenu(String contenu) { this.contenu = contenu; }
    public LocalDateTime getDateEnvoi() { return dateEnvoi; }
    public void setDateEnvoi(LocalDateTime dateEnvoi) { this.dateEnvoi = dateEnvoi; }
    public String getReponse() { return reponse; }
    public void setReponse(String reponse) { this.reponse = reponse; }
    public LocalDateTime getDateReponse() { return dateReponse; }
    public void setDateReponse(LocalDateTime dateReponse) { this.dateReponse = dateReponse; }
}
