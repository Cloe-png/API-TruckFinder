package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "foodtrucks")
public class Foodtruck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "type_cuisine", length = 100)
    private String typeCuisine;

    @Column(length = 255)
    private String adresse;

    @Column(length = 20)
    private String telephone;

    @Column(length = 255)
    private String logo;

    @Column(columnDefinition = "JSON")
    private String menu;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Statut statut = Statut.EN_ATTENTE;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation = LocalDateTime.now();

    @OneToMany(mappedBy = "foodtruck", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Adresse> adresses;

    @Column(name = "est_ouvert")
    private Boolean estOuvert = false;

    public enum Statut {
        EN_ATTENTE, APPROUVE, REJETE
    }

    // Getters et Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getTypeCuisine() { return typeCuisine; }
    public void setTypeCuisine(String typeCuisine) { this.typeCuisine = typeCuisine; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getLogo() { return logo; }
    public void setLogo(String logo) { this.logo = logo; }
    public String getMenu() { return menu; }
    public void setMenu(String menu) { this.menu = menu; }
    public Statut getStatut() { return statut; }
    public void setStatut(Statut statut) { this.statut = statut; }
    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }
    public List<Adresse> getAdresses() { return adresses; }
    public void setAdresses(List<Adresse> adresses) { this.adresses = adresses; }
    public Boolean getEstOuvert() { return estOuvert; }
    public void setEstOuvert(Boolean estOuvert) { this.estOuvert = estOuvert; }
}
