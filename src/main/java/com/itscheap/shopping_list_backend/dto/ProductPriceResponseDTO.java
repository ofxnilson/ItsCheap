package com.itscheap.shopping_list_backend.dto;
/**
 * DTO for sending product price info to the client.
 */
public class ProductPriceResponseDTO {
    private Long id;
    private String productName;
    private String supermarket;
    private double price;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getSupermarket() { return supermarket; }
    public void setSupermarket(String supermarket) { this.supermarket = supermarket; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
