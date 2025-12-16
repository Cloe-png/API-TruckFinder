package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public Message envoyerMessage(@RequestBody Message message) {
        return messageService.envoyerMessage(message);
    }

    @PutMapping("/{idMessage}/repondre")
    public Message repondreMessage(@PathVariable Integer idMessage, @RequestParam String reponse) {
        return messageService.repondreMessage(idMessage, reponse);
    }

    @GetMapping("/foodtruck/{idFoodtruck}")
    public List<Message> obtenirMessagesParFoodtruck(@PathVariable Integer idFoodtruck) {
        return messageService.obtenirMessagesParFoodtruck(idFoodtruck);
    }
}
