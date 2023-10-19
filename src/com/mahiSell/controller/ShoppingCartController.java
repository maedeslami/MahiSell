package com.mahiSell.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private Map<String, Integer> cartItems;

    public ShoppingCartController() {
        this.cartItems = new HashMap<>();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addItemToCart(@RequestParam String itemId, @RequestParam int quantity) {
        // Add item to cart or update quantity
        cartItems.put(itemId, cartItems.getOrDefault(itemId, 0) + quantity);
        return ResponseEntity.ok("Item added to cart");
    }

    @GetMapping("/view")
    public ResponseEntity<Map<String, Integer>> viewCart() {
        // Return the current cart items and quantities
        return ResponseEntity.ok(cartItems);
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeItemFromCart(@RequestParam String itemId) {
        // Remove item from cart
        cartItems.remove(itemId);
        return ResponseEntity.ok("Item removed from cart");
    }

    @PostMapping("/clear")
    public ResponseEntity<String> clearCart() {
        // Clear the entire cart
        cartItems.clear();
        return ResponseEntity.ok("Cart cleared");
    }
}