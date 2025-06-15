package com.itscheap.shopping_list_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// JPA Entity for supermarkets
@Entity
public class Supermarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Supermarket name, must be unique
    @Column(unique = true, nullable = false)
    private String name;

    // Optional: address, logo, etc. can be added

    // Constructors
    public Supermarket() {
    }

    public Supermarket(String name) {
        this.name = name;
    }

    // Getters and setters
    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }
}
