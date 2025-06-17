package com.itscheap.shopping_list_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Marks this class as a JPA entity, mapped to a table named "product_prices"
@Entity
@Table(name = "product_prices")
public class ProductPrice {

    // Primary key, auto-generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // JPA relationship: many prices can refer to one product
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false) // Foreign key column in DB
    private Product product;

    // Name of supermarket where this price was found
    private String supermarket;

    // The price value
    private double price;

    // Constructors
    public ProductPrice() {}

    public ProductPrice(Product product, String supermarket, double price) {
        this.product = product;
        this.supermarket = supermarket;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public String getSupermarket() { return supermarket; }
    public void setSupermarket(String supermarket) { this.supermarket = supermarket; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

