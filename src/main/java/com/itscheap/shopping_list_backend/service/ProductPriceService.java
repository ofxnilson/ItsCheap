package com.itscheap.shopping_list_backend.service;

import com.itscheap.shopping_list_backend.model.Product;
import com.itscheap.shopping_list_backend.model.ProductPrice;
import com.itscheap.shopping_list_backend.repository.ProductRepository;
import com.itscheap.shopping_list_backend.repository.ProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Service class for handling business logic related to ProductPrice entities.
 */
@Service
public class ProductPriceService {

    // Injects the repository for accessing Product data from the database
    @Autowired
    private ProductRepository productRepository;

    // Injects the repository for accessing ProductPrice data from the database
    @Autowired
    private ProductPriceRepository productPriceRepository;

    /**
     * Retrieves all ProductPrice entries for a given product name (case-insensitive).
     * @param productName The name of the product to search for.
     * @return A list of ProductPrice entries for the specified product, or an empty list if not found.
     */
    public List<ProductPrice> getPricesForProductName(String productName) {
        // Find the product by name (ignoring case)
        Optional<Product> productOpt = productRepository.findByNameIgnoreCase(productName);

        // If the product doesn't exist, return an empty list
        if (productOpt.isEmpty()) {
            return Collections.emptyList();
        }

        // Retrieve all price entries for the found product
        return productPriceRepository.findByProduct(productOpt.get());
    }

    /**
     * Adds a new ProductPrice entry for a product (by product name).
     * If the product does not exist, throws an exception.
     * @param productName The name of the product.
     * @param price The ProductPrice entity with price/supermarket set.
     * @return The saved ProductPrice entity.
     */
    public ProductPrice addProductPrice(String productName, ProductPrice price) {
        // Find the product by name (ignoring case)
        Optional<Product> productOpt = productRepository.findByNameIgnoreCase(productName);

        // If product doesn't exist, throw an exception
        if (productOpt.isEmpty()) {
            throw new IllegalArgumentException("Product not found: " + productName);
        }

        // Set the product reference on the ProductPrice entity
        price.setProduct(productOpt.get());

        // Save the ProductPrice entry
        return productPriceRepository.save(price);
    }
}
