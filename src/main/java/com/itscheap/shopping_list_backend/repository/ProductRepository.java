package com.itscheap.shopping_list_backend.repository;

// Import JpaRepository from Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

import com.itscheap.shopping_list_backend.model.Product;

// Interface for database operations on Product entities
// Extends JpaRepository, providing built-in CRUD methods
public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can add custom queries here if needed later
}
