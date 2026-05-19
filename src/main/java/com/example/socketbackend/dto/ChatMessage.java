package com.example.socketbackend.dto;

import com.example.socketbackend.enums.MessageType;

public record ChatMessage(MessageType type, String sender, String content) {

}
