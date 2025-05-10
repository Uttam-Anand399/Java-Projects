package com.ay.services.impl;

import com.ay.entity.Order;
import com.ay.entity.OrderItem;
import com.ay.repository.OrderRepo;
import com.ay.services.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepository;

    public OrderServiceImpl(OrderRepo orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        // Calculate total amount
        double totalAmount = 0;
        for (OrderItem item : order.getItems()) {
            totalAmount += item.getPrice() * item.getQuantity();
        }
        order.setTotalAmount(totalAmount);

        return orderRepository.save(order);  // Save the order to the database
    }
}
