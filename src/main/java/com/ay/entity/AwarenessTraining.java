package com.ay.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AwarenessTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sessionType; // "Online Training" or "Village Training"
    private String topic;       // "Modern Farming Techniques", etc.
    private String description;

    // Constructors
    public AwarenessTraining() {}

    public AwarenessTraining(String sessionType, String topic, String description) {
        this.sessionType = sessionType;
        this.topic = topic;
        this.description = description;
    }

    // Getters and Setters
   
}
