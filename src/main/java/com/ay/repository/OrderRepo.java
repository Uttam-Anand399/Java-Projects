package com.ay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ay.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
