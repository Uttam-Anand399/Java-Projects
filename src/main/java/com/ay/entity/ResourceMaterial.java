package com.ay.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String type; // e.g., "Article", "Video", "Tutorial"

    @Column(length = 1000)
    private String description;

    private String url; // Link to resource (PDF, YouTube video, etc.)
}
