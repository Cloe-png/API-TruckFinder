package com.example.foodtruck;

import com.example.foodtruck.model.FoodTruck;
import com.example.foodtruck.repository.FoodTruckRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FoodtruckApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodtruckApiApplication.class, args);
    }

    @Bean
    CommandLineRunner init(FoodTruckRepository repo){
        return args -> {
            if(repo.count()==0){
                repo.save(new FoodTruck(null,"Tacos El Pablo","Mexican","75001","11:00-15:00",true));
                repo.save(new FoodTruck(null,"Burger Street","Burgers","75015","12:00-22:00",true));
            }
        };
    }
}
