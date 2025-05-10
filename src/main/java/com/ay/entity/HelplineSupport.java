package com.ay.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HelplineSupport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String queryType; // Call or Chat
    private String userName;
    private String contactInfo;
    private String queryDetails;
    private String status; // e.g. Open, Resolved, In-progress
}
