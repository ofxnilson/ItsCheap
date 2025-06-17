package com.itscheap.shopping_list_backend.dto;
/**
 * DTO for returning user info (NEVER include the password here!).
 */
public class UserResponseDTO {
    private Long id;
    private String username;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
