package com.ay.services.impl;

import com.ay.entity.Product;
import com.ay.repository.ProductRepo;
import com.ay.services.ProductService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> addProducts(List<Product> products) {
        return productRepo.saveAll(products); // BULK SAVE
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        if (productRepo.existsById(id)) {
            product.setId(id);
            return productRepo.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
        }
    }
}
