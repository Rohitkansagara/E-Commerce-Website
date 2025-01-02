package com.a99.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id; // Ensure the id field is defined

    private String name;
    private double price;

    // Other fields, constructors, and methods can be added as required.

    // Default constructor
    public Product() {}

    // Constructor for Product creation
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter for id field
    public Long getId() {
        return id;
    }

    // Setter for id field
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for name field
    public String getName() {
        return name;
    }

    // Setter for name field
    public void setName(String name) {
        this.name = name;
    }

    // Getter for price field
    public double getPrice() {
        return price;
    }

    // Setter for price field
    public void setPrice(double price) {
        this.price = price;
    }

    // Additional methods and validation can be added as necessary
}
