package com.itscheap.shopping_list_backend.controller;

// Import necessary Spring and Java packages
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itscheap.shopping_list_backend.model.Product;
import com.itscheap.shopping_list_backend.repository.ProductRepository;

// This class will handle HTTP requests related to products
@RestController
@RequestMapping("/api/products")
public class ProductController {

    // Inject the ProductRepository to interact with the database
    @Autowired
    private ProductRepository repo;

    // GET endpoint to retrieve all products
    @GetMapping
    public List<Product> getAll() {
        // Returns a list of all products from the database
        return repo.findAll();
    }

    // POST endpoint to add a new product
    @PostMapping
    public Product add(@RequestBody Product product) {
        // Saves the product to the database and returns the saved object
        return repo.save(product);
    }
}

