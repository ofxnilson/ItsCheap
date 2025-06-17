package com.itscheap.shopping_list_backend.repository;

// Import the JpaRepository interface from Spring Data JPA
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itscheap.shopping_list_backend.model.Product;

/**
 * ProductRepository is a Spring Data JPA repository interface.
 * 
 * - Extends JpaRepository, which provides standard CRUD methods (save, findAll, delete, etc.)
 * - Defines a custom query method to find products by name, ignoring case sensitivity.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Finds a Product by its name, ignoring case sensitivity.
     *
     * @param name The name of the product to search for.
     * @return An Optional containing the Product if found, or empty if not found.
     * 
     * Spring Data JPA will automatically implement this method based on its name.
     * It will generate the appropriate SQL: "SELECT * FROM products WHERE LOWER(name) = LOWER(?1)"
     */
    Optional<Product> findByNameIgnoreCase(String name);

    // You can add more custom query methods here as needed!
}
