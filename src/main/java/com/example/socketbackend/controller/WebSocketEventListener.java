package com.example.socketbackend.controller;

import com.example.socketbackend.dto.ChatMessage;
import com.example.socketbackend.enums.MessageType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
public class WebSocketEventListener {
    private final SimpMessageSendingOperations messageTemplate;

    @EventListener
    public void handleWebSocketConnect(SessionDisconnectEvent event){
        // ToDo - to be implement
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) accessor.getSessionAttributes().get("username");

        if (username != null){
            System.out.println("User Disconnected: "+ username);
            ChatMessage message = new ChatMessage(MessageType.LEAVE, username, null);

            messageTemplate.convertAndSend("/topic/public", message);
        }
    }


}
