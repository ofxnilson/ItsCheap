package com.itscheap.shopping_list_backend.dto;
/**
 * DTO for returning supermarket data.
 */
public class SupermarketResponseDTO {
    private Long id;
    private String name;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
