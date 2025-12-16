package com.example.demo.service;

import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message envoyerMessage(Message message) {
        message.setDateEnvoi(LocalDateTime.now());
        return messageRepository.save(message);
    }

    public Message repondreMessage(Integer idMessage, String reponse) {
        Message message = messageRepository.findById(idMessage).orElseThrow(() -> new RuntimeException("Message non trouvé"));
        message.setReponse(reponse);
        message.setDateReponse(LocalDateTime.now());
        return messageRepository.save(message);
    }

    public List<Message> obtenirMessagesParFoodtruck(Integer idFoodtruck) {
        return messageRepository.findByFoodtruck_Id(idFoodtruck);
    }
}
