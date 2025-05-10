package com.ay.services;

import com.ay.entity.Product;
import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> addProducts(List<Product> products); // BULK INSERT
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
