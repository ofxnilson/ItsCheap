package com.itscheap.shopping_list_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itscheap.shopping_list_backend.model.ProductPrice;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {
    List<ProductPrice> findByProductNameIgnoreCase(String productName);
}
