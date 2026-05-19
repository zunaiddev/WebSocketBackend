package com.example.socketbackend.controller;

import com.example.socketbackend.dto.ChatMessage;
import jakarta.annotation.security.PermitAll;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMsg(@Payload ChatMessage message){
        return message;
    }

    public ChatMessage addUser(@Payload ChatMessage message, SimpMessageHeaderAccessor accessor){
        // Add user in websocket session
        accessor.getSessionAttributes().put("username", message.sender());

    }
}
