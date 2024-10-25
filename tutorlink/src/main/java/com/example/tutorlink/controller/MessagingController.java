package com.example.tutorlink.controller;

import com.example.tutorlink.model.dto.request.message.MessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessagingController {

    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO messageDTO) {
        System.out.println("Received message: " + messageDTO.getMessage());

        return ResponseEntity.ok("Message received");
    }
}