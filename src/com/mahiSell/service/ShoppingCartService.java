package com.mahiSell.service;

import com.mahiSell.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartService {

    private final Map<String, Integer> cartItems;
    @Autowired
    CartRepository repository;

    public ShoppingCartService() {
        this.cartItems = new HashMap<>();
    }

    public void addItemToCart(String itemId, int quantity) {
        // Add item to cart or update quantity
        cartItems.put(itemId, cartItems.getOrDefault(itemId, 0) + quantity);
    }

    public Map<String, Integer> viewCart() {
        // Return the current cart items and quantities
        return cartItems;
    }

    public void removeItemFromCart(String itemId) {
        // Remove item from cart
        cartItems.remove(itemId);
    }

    public void clearCart() {
        // Clear the entire cart
        cartItems.clear();
    }
}