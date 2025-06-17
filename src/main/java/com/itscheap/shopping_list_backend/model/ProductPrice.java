package com.itscheap.shopping_list_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_prices")
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to Product entity (already present)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Link to Supermarket entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supermarket_id", nullable = false)
    private Supermarket supermarket;

    private double price;

    // Constructors
    public ProductPrice() {}

    public ProductPrice(Product product, Supermarket supermarket, double price) {
        this.product = product;
        this.supermarket = supermarket;
        this.price = price;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public Supermarket getSupermarket() { return supermarket; }
    public void setSupermarket(Supermarket supermarket) { this.supermarket = supermarket; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

