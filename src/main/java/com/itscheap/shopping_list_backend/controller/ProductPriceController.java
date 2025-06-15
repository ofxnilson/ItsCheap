package com.itscheap.shopping_list_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itscheap.shopping_list_backend.model.ProductPrice;
import com.itscheap.shopping_list_backend.service.ProductPriceService;

@RestController
@RequestMapping("/api/products")
public class ProductPriceController {
    private final ProductPriceService service;

    public ProductPriceController(ProductPriceService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductPrice> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ProductPrice> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ProductPrice add(@RequestBody ProductPrice productPrice) {
        return service.addOrUpdate(productPrice);
    }

    @PutMapping("/{id}")
    public ProductPrice update(@PathVariable Long id, @RequestBody ProductPrice productPrice) {
        productPrice.setId(id);
        return service.addOrUpdate(productPrice);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/compare")
    public List<ProductPrice> compare(@RequestParam String productName) {
        return service.getByProductName(productName);
    }
}
