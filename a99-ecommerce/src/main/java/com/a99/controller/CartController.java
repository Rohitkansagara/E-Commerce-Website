package com.a99.controller;

import com.a99.model.Cart;
import com.a99.model.CartItem;
import com.a99.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Get the current cart of a user
    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getUserCart(@PathVariable Long userId) {
        return cartService.getUserCart(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add an item to the user's cart
    @PostMapping("/{userId}")
    public ResponseEntity<Cart> addItemToCart(@PathVariable Long userId, @RequestBody CartItem cartItem) {
        Cart updatedCart = cartService.addItemToCart(userId, cartItem);
        return ResponseEntity.ok(updatedCart);
    }

    // Remove an item from the user's cart
    @DeleteMapping("/{userId}/{itemId}")
    public ResponseEntity<Cart> removeItemFromCart(@PathVariable Long userId, @PathVariable Long itemId) {
        Cart updatedCart = cartService.removeItemFromCart(userId, itemId);
        return ResponseEntity.ok(updatedCart);
    }

    // Clear all items in the user's cart
    @DeleteMapping("/{userId}/clear")
    public ResponseEntity<Cart> clearCart(@PathVariable Long userId) {
        Cart clearedCart = cartService.clearCart(userId);
        return ResponseEntity.ok(clearedCart);
    }
}
