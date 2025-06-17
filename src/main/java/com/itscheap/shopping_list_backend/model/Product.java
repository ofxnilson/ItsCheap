package com.itscheap.shopping_list_backend.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// Marks this class as a JPA entity, mapped to a table named "product"
@Entity
@Table(name = "product")
public class Product {

    // Primary key, auto-generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name column, cannot be null
    @Column(nullable = false, unique = true)
    private String name;

    // (Optional) OneToMany relationship for all prices related to this product
    // CascadeType.ALL means if a product is deleted, its prices are too
    // mappedBy must match the field name in ProductPrice
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductPrice> prices;

    // Constructors
    public Product() {}

    public Product(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<ProductPrice> getPrices() { return prices; }
    public void setPrices(List<ProductPrice> prices) { this.prices = prices; }
}
