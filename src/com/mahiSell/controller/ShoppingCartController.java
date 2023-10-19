package com.mahiSell.controller;

import com.mahiSell.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService service;

    @PostMapping("/add")
    public ResponseEntity<String> addItemToCart(@RequestBody String itemId, @RequestBody int quantity) {
        service.addItemToCart(itemId, quantity);
        return ResponseEntity.ok("Item added to cart");
    }

    @GetMapping("/view")
    public ResponseEntity<Map<String, Integer>> viewCart() {
        return ResponseEntity.ok(service.viewCart());
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeItemFromCart(@RequestBody String itemId) {
        // Remove item from cart
        service.removeItemFromCart(itemId);
        return ResponseEntity.ok("Item removed from cart");
    }

    @PostMapping("/clear")
    public ResponseEntity<String> clearCart() {
        // Clear the entire cart
        service.clearCart();
        return ResponseEntity.ok("Cart cleared");
    }
}