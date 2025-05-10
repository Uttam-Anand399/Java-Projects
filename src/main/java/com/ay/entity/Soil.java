package com.ay.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "soils")
@Data
public class Soil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String texture;
    private String pHLevel;
    private String organicMatter;
    private String waterRetention;
    private String idealCrops;

    @Column(length = 1000)
    private String description;
}
