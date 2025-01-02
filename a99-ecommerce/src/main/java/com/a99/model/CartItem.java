package com.a99.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;

@Setter
@Getter
@Data
@Entity
public class CartItem {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")  // Foreign key for Cart
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")  // Foreign key for Product
    private Product product;

    private int quantity;

    private double price;  // Assuming using double for price

    public void setPrice(BigDecimal price) {
        this.price = price.doubleValue();  // Optionally handle conversion if BigDecimal is preferred
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
