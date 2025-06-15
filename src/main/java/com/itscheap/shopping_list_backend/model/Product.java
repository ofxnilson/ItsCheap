package com.itscheap.shopping_list_backend.model;

// Import JPA and validation packages
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// JPA class entity for ORM mapping
@Entity
public class Product {

    // Primary key, auto-generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Product name
    private String name;

    // Product price
    private Double price;

    // Add relationship to Supermarket
    @ManyToOne
    @JoinColumn(name = "supermarket_id")
    private Supermarket supermarket;

    // Getters and Setters
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Supermarket getSupermarket() { 
        return supermarket; 
    }

    public void setSupermarket(Supermarket supermarket) { 
        this.supermarket = supermarket; 
    }
}
