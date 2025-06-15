package com.itscheap.shopping_list_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itscheap.shopping_list_backend.model.Supermarket;

public interface SupermarketRepository extends JpaRepository<Supermarket, Long> {
    // Add custom queries if needed
}
