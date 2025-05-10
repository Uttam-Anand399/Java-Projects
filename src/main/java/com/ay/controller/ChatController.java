package com.ay.controller;

import com.ay.model.ChatMessage;
import com.ay.services.AutoReplyService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final AutoReplyService autoReplyService;

    public ChatController(SimpMessagingTemplate messagingTemplate, AutoReplyService autoReplyService) {
        this.messagingTemplate = messagingTemplate;
        this.autoReplyService = autoReplyService;
    }

    @MessageMapping("/chat")
    public void receiveMessage(ChatMessage message) {
        message.setTimestamp(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        messagingTemplate.convertAndSend("/topic/messages", message);

        // If from Farmer, generate expert auto-reply
        if ("Farmer".equalsIgnoreCase(message.getSender())) {
            new Thread(() -> {
                try {
                    Thread.sleep(1500); // Simulate delay
                    String replyText = autoReplyService.generateReply(message.getContent());
                    ChatMessage reply = new ChatMessage();
                    reply.setSender("Expert");
                    reply.setContent(replyText);
                    reply.setTimestamp(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                    messagingTemplate.convertAndSend("/topic/messages", reply);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
