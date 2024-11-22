package org.example;

// Program Name: Guitar Store POS - Cart
// Program Purpose: Manage the cart system and calculate the till amounts
// Author: Jarrod Ferriss
// Date: 2024-09-22

import org.example.objects.Guitar;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    // List to hold the items in the cart
    private List<Guitar> cart = new ArrayList<>();
    private static final float TAX_RATE = 0.13f;

    // Add a guitar to the cart
    public void addToCart(Guitar guitar) {
        cart.add(guitar);
        System.out.println(guitar.getSpec().getProperty("brand") + " " +
                guitar.getSpec().getProperty("body") + " has been added to the cart.");
    }

    // Display the contents of the cart
    public void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Items in cart:");
            for (Guitar guitar : cart) {
                System.out.println(guitar);
            }
        }
    }

    // Calculate the subtotal
    public float calculateSubTotal() {
        float subTotal = 0.0f;
        for (Guitar guitar : cart) {
            subTotal += guitar.getPrice();
        }
        return subTotal;
    }

    // Calculate the tax
    public float calculateTax(float subTotal) {
        return subTotal * TAX_RATE;
    }

    // Calculate the total amount
    public float calculateTotal(float subTotal, float tax) {
        return subTotal + tax;
    }

    // Cash out and calculate change
    public float cashOut(float cashProvided) {
        float subTotal = calculateSubTotal();
        float tax = calculateTax(subTotal);
        float total = calculateTotal(subTotal, tax);

        if (cashProvided < total) {
            System.out.println("Insufficient cash provided.");
            return -1; // Indicate an error in cash provided
        }

        return cashProvided - total;
    }
}
