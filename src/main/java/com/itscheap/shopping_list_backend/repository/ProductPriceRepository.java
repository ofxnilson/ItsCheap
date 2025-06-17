package com.itscheap.shopping_list_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itscheap.shopping_list_backend.model.Product;
import com.itscheap.shopping_list_backend.model.ProductPrice;

/**
 * Repository for ProductPrice data access.
 */
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {
    // Finds all ProductPrice entries for the given Product entity
    List<ProductPrice> findByProduct(Product product);
}
