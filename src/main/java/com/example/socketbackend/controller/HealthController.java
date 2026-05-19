package com.example.socketbackend.controller;

import com.example.socketbackend.dto.ChatMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/test")
    public String health(){
        return "Healthy";
    }

    @PostMapping
    public ChatMessage testBody(@RequestBody ChatMessage message){
        System.out.println("Message: " + message);
        return message;
    }
}