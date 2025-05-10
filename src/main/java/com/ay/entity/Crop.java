package com.ay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "crops")
@Data
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cropType;
    private String season;
    private String soilType;
    private String idealTemperature;
    private String waterRequirement;
    
    @Column(length = 1000)
    private String fertilizers;

    private String yieldPerHectare;

    @Column(length = 1000)
    private String imageUrl;

  
}
