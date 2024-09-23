package org.example;

// Program Name: Guitar Store POS - Cart
// Program Purpose: Manage the cart system and calculate the till amounts
// Author: Jarrod Ferriss
// Date: 2024-09-22

import org.example.objects.Guitar;
import java.util.ArrayList;

public class Cart {

    //Initialize the ArrayList to contain the cart contents
    ArrayList<Guitar> cart = new ArrayList<>();
    //Initialize the subtotal variable
    float subTotal = 0.00f;
    float tax = 0.00f;

    //Add to cart
    public void addToCart(Guitar guitar) {

        //Add the guitar to the arrayList
        cart.add(guitar);
        System.out.println(guitar.getBrand() + " " +
                guitar.getBody() + " has been added to the cart.");
    }

    //Display the cart
    public void displayCart() {

        System.out.println("Items in cart: ");
        //For each guitar in the cart
        for (Guitar guitar : cart) {
            System.out.println(guitar);
        }
    }

    //Subtotal
    public float subTotal(Guitar guitar) {

        //save the price of the guitar to a variable
        float guitarPrice = guitar.getPrice();
        //Add the price of the guitar to the subtotal
        subTotal += guitarPrice;

        return subTotal;
    }

    //Tax
    public float tax(float subTotal) {

        //Calculate the running total of tax to be paid
        tax += subTotal * 0.13f;

        return tax;
    }

    //Final total
    public float total(float subTotal, float tax) {

        //Calculate the final total and return
        return subTotal + tax;
    }

    //Cash out
    public float cashout(float total, float cash) {

        //Calculate the change and return
        return cash - total;
    }
}
