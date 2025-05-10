package com.ay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ay.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
