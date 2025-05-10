package com.ay.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MultilingualSupport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language;     // e.g., Hindi, Tamil, Bengali, etc.
    private String description;  // Details about support or translation info

    public MultilingualSupport() {}

    public MultilingualSupport(String language, String description) {
        this.language = language;
        this.description = description;
    }

   
}
