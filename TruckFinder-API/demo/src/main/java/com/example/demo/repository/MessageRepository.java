package com.example.demo.repository;

import com.example.demo.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByFoodtruck_Id(Integer idFoodtruck);
}
