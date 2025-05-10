package com.ay.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebRTCController {

    // Handle call offer from Farmer
    @MessageMapping("/call")
    @SendTo("/topic/call")
    public String handleCallOffer(String offer) {
        // In a real app, you'd forward the offer to the expert
        return offer;
    }

    // Handle answer from Expert
    @MessageMapping("/answer")
    @SendTo("/topic/answer")
    public String handleCallAnswer(String answer) {
        // In a real app, you'd forward the answer to the farmer
        return answer;
    }
}
