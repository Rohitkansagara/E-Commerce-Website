package com.a99.service;

import com.a99.model.Cart;
import com.a99.model.CartItem;
import com.a99.model.Product;
import com.a99.model.User;
import com.a99.repository.CartRepository;
import com.a99.repository.CartItemRepository;
import com.a99.repository.ProductRepository;
import com.a99.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository,
                       ProductRepository productRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    // Method to get the current cart of a user
    public Optional<Cart> getUserCart(Long userId) {
        return cartRepository.findByUserId(userId);  // Assuming Cart has a user reference
    }

    // Add an item to the cart
    public Cart addItemToCart(Long userId, CartItem cartItem) {
        // Find the user and product by ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(cartItem.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Set the price (assuming the price is in BigDecimal)
        double productPrice = product.getPrice();
        cartItem.setPrice(BigDecimal.valueOf(productPrice));

        // Associate the CartItem with the User's Cart
        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> createCart(user));

        cartItem.setCart(cart);  // Set the Cart for the CartItem
        cartItemRepository.save(cartItem);  // Persist CartItem

        cart.addCartItem(cartItem);  // Use the Cart method to add the item
        cartRepository.save(cart);  // Persist the updated cart

        return cart;
    }

    // Remove an item from the cart
    public Cart removeItemFromCart(Long userId, Long itemId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user"));

        CartItem cartItem = cartItemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));

        cart.removeCartItem(cartItem);  // Use the Cart method to remove the item
        cartItemRepository.delete(cartItem);  // Remove from CartItem repository

        cartRepository.save(cart);  // Persist updated Cart

        return cart;
    }

    // Clear all items from the user's cart
    public Cart clearCart(Long userId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user"));

        cart.clear();  // Use the Cart method to clear the items
        cartRepository.save(cart);  // Save the cleared Cart

        return cart;
    }

    // Helper method to create a cart for the user if it doesn't exist
    private Cart createCart(User user) {
        Cart cart = new Cart(user);  // Create new cart for the user
        return cartRepository.save(cart);  // Save and return the new Cart
    }
}
