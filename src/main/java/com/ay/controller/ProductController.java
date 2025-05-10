package com.ay.controller;

import com.ay.entity.Product;
import com.ay.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // POST single product
    @PostMapping
    
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product saved = productService.addProduct(product);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // ✅ POST multiple products (bulk insert)
    @PostMapping("/bulk")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
        List<Product> savedList = productService.addProducts(products);
        return new ResponseEntity<>(savedList, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
