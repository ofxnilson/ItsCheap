package com.itscheap.shopping_list_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itscheap.shopping_list_backend.model.Product;
import com.itscheap.shopping_list_backend.repository.ProductRepository;

/**
 * REST controller for handling Product CRUD operations.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    // Inject the ProductRepository to interact with the database
    @Autowired
    private ProductRepository productRepository;

    /**
     * Get a list of all products.
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Create a new product.
     */
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product saved = productRepository.save(product);
        return ResponseEntity.ok(saved);
    }

    /**
     * Get a single product by its ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Add other CRUD operations if needed (update, delete)
}
