package com.ay.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpertConsultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String meetingType; // "Online" or "Offline"
    private String cropDiseaseAdvice;
    private String fertilizerAdvice;
    private String pestControl;
    private String bestPractices;
}
