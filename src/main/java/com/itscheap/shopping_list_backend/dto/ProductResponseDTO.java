package com.itscheap.shopping_list_backend.dto;
/**
 * This DTO is used for returning product data to the client.
 */
public class ProductResponseDTO {
    // The product's unique ID
    private Long id;
    // The product name
    private String name;
    // Optional: description
    private String description;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
