package com.ay.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;  // You can use authentication for user ID (from JWT or session)
    private String shippingAddress;
    private Double totalAmount;  // Calculate the total amount of the order

    @OneToMany(cascade = CascadeType.ALL)  // Each order can have multiple order items
    private List<OrderItem> items;

   
}
