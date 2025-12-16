package com.example.foodtruck.model;

import jakarta.persistence.*;

@Entity
public class FoodTruck {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cuisineType;
    private String postalCode;
    private String openingHours;
    private boolean active;

    public FoodTruck(){}
    public FoodTruck(Long id,String name,String cuisine,String postal,String hours,boolean active){
        this.id=id;this.name=name;this.cuisineType=cuisine;this.postalCode=postal;this.openingHours=hours;this.active=active;
    }

    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String n){this.name=n;}
    public String getCuisineType(){return cuisineType;} public void setCuisineType(String c){this.cuisineType=c;}
    public String getPostalCode(){return postalCode;} public void setPostalCode(String p){this.postalCode=p;}
    public String getOpeningHours(){return openingHours;} public void setOpeningHours(String o){this.openingHours=o;}
    public boolean isActive(){return active;} public void setActive(boolean a){this.active=a;}
}
