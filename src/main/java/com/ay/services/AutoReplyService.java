package com.ay.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AutoReplyService {

    private final Map<String, String> responseMap = new HashMap<>();

    public AutoReplyService() {
        responseMap.put("crop", "Please specify the crop name, and I'll guide you further.");
        responseMap.put("pest", "For pest control, consider organic pesticides like neem oil.");
        responseMap.put("weather", "You can view the weather forecast in the Weather section.");
        responseMap.put("fertilizer", "Apply fertilizer based on soil test results. Need help?");
    }

    public String generateReply(String userMessage) {
        for (String keyword : responseMap.keySet()) {
            if (userMessage.toLowerCase().contains(keyword)) {
                return responseMap.get(keyword);
            }
        }
        return "Thank you for your message. Our expert will reply shortly.";
    }
}
