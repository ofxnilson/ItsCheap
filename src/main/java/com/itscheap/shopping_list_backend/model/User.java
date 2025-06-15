package com.itscheap.shopping_list_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

// JPA Entity mapped to the 'user' table
@Entity
@Table(name = "users") // 'user' is a reserved word in some databases
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Username must not be blank
    @NotBlank
    @Column(unique = true)
    private String username;

    // Password must be 8+ chars, 1+ letter, 1+ symbol
    @NotBlank
    @Size(min = 8)
    @Pattern(
        regexp = "^(?=.*[A-Za-z])(?=.*\\W).{8,}$",
        message = "Password must be at least 8 characters and include at least one letter and one symbol."
    )
    private String password;

    // Constructors
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public String getUsername() { 
        return username; 
    }

    public void setUsername(String username) { 
        this.username = username; 
    }

    public String getPassword() { 
        return password; 
    }
    public void setPassword(String password) { 
        this.password = password; 
    }
}

