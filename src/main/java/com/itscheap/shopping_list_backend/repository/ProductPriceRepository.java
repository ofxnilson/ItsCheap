package com.itscheap.shopping_list_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itscheap.shopping_list_backend.model.Product;
import com.itscheap.shopping_list_backend.model.ProductPrice;
import com.itscheap.shopping_list_backend.model.Supermarket;

/**
 * Repository for ProductPrice data access.
 */
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {
    // Find all prices for a product in a supermarket
    List<ProductPrice> findByProductAndSupermarket(Product product, Supermarket supermarket);
}
