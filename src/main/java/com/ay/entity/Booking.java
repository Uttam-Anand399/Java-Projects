package com.ay.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pickupLocation;
    private String dropLocation;
    private LocalDateTime bookingTime;
    private String vehicleType;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    
}
