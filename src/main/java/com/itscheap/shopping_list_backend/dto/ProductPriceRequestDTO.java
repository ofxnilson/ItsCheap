package com.itscheap.shopping_list_backend.dto;
/**
 * DTO for creating/updating a product price.
 * This references a product by name (or ID, if you want to change).
 */
public class ProductPriceRequestDTO {
    // The name of the product (required)
    private String productName;
    // The supermarket's name
    private String supermarket;
    // The price of the product
    private double price;

    // Getters and setters
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getSupermarket() { return supermarket; }
    public void setSupermarket(String supermarket) { this.supermarket = supermarket; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
