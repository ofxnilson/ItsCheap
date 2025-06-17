package com.itscheap.shopping_list_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itscheap.shopping_list_backend.model.ProductPrice;
import com.itscheap.shopping_list_backend.service.ProductPriceService;

/**
 * REST controller for managing ProductPrice endpoints.
 */
@RestController
@RequestMapping("/api/product-prices")
public class ProductPriceController {

    // Injects the service that handles business logic
    @Autowired
    private ProductPriceService productPriceService;

    /**
     * GET endpoint to retrieve all price entries for a product by its name.
     * Example: GET /api/product-prices?productName=Milk
     *
     * @param productName The name of the product to search for.
     * @return A list of ProductPrice entries (HTTP 200).
     */
    @GetMapping
    public ResponseEntity<List<ProductPrice>> getPricesForProduct(
            @RequestParam String productName
    ) {
        // Get all prices for the given product name using the service
        List<ProductPrice> prices = productPriceService.getPricesForProductName(productName);
        return ResponseEntity.ok(prices);
    }

    /**
     * POST endpoint to add a new price entry for a product (by name).
     * Example: POST /api/product-prices?productName=Milk
     * Body: { "supermarket": "...", "price": 2.99 }
     *
     * @param productName The name of the product.
     * @param productPrice The price details (JSON in request body).
     * @return The saved ProductPrice entry (HTTP 200).
     */
    @PostMapping
    public ResponseEntity<ProductPrice> addProductPrice(
            @RequestParam String productName,
            @RequestBody ProductPrice productPrice
    ) {
        // Add the new price entry using the service
        ProductPrice saved = productPriceService.addProductPrice(productName, productPrice);
        return ResponseEntity.ok(saved);
    }
}
