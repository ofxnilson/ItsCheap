package com.itscheap.shopping_list_backend.dto;
/**
 * This DTO is used for creating/updating a product.
 * You can add validation annotations here (e.g., @NotBlank, @Size).
 */
public class ProductRequestDTO {
    // The product name (required)
    private String name;

    // Optional: description
    private String description;

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
