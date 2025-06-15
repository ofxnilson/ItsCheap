package com.itscheap.shopping_list_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.itscheap.shopping_list_backend.model.ProductPrice;
import com.itscheap.shopping_list_backend.repository.ProductPriceRepository;

@Service
public class ProductPriceService {
    private final ProductPriceRepository repository;

    public ProductPriceService(ProductPriceRepository repository) {
        this.repository = repository;
    }

    public ProductPrice addOrUpdate(ProductPrice productPrice) {
        return repository.save(productPrice);
    }

    public List<ProductPrice> getAll() {
        return repository.findAll();
    }

    public Optional<ProductPrice> getById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<ProductPrice> getByProductName(String productName) {
        return repository.findByProductNameIgnoreCase(productName);
    }
}

