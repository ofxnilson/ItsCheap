package com.itscheap.shopping_list_backend.dto;
/**
 * DTO for user registration.
 */
public class UserRegistrationDTO {
    private String username;
    private String password; // Should meet password policy

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
