package com.ay.controller;

import com.ay.entity.Order;
import com.ay.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        // Create order in the database
        Order savedOrder = orderService.createOrder(order);

        // Return the saved order along with the status code
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}
