package com.a99.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Setter
@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private double totalPrice;



    public Cart(User user) {
        this.user = user;
    }

    // Adding a CartItem to the cart
    public void addCartItem(CartItem cartItem) {
        if (cartItems == null) {
            cartItems = new HashSet<>();
        }
        cartItems.add(cartItem);
        calculateTotalPrice();
    }

    // Removing a CartItem from the cart
    public void removeCartItem(CartItem cartItem) {
        if (cartItems != null && cartItems.contains(cartItem)) {
            cartItems.remove(cartItem);
        }
        calculateTotalPrice();
    }

    // Clear all CartItems from the cart
    public void clear() {
        if (cartItems != null) {
            cartItems.clear();
        }
        calculateTotalPrice();
    }

    // Calculate the total price of the cart
    private void calculateTotalPrice() {
        this.totalPrice = cartItems.stream()
                .mapToDouble(CartItem::getPrice)
                .sum();
    }
    public Cart() {
        // This constructor is required for Hibernate
    }

}
