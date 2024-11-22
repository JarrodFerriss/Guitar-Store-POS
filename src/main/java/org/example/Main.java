package org.example;

import org.example.objects.Guitar;
import org.example.objects.GuitarSpec;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Initialize loop sentinel variables
        boolean loop = true;

        // Instantiate and initialize the storeInventory
        StoreInventory storeInventory = new StoreInventory();
        storeInventory.initializeInventory();

        // Instantiate the cart
        Cart cart = new Cart();

        // Begin the main program loop
        while (loop) {

            // Ask the user to log in
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to our guitar shop!");
            System.out.println("Sign in to begin purchasing.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            System.out.println("Please enter the Store Number (659874): "); // Store number given
            int storeNumber = scanner.nextInt();

            System.out.println("Please enter Employee ID (564231): "); // Employee ID given
            int employeeID = scanner.nextInt();

            // Instantiate the login script
            Login login = new Login();

            // If the credentials are valid
            if (login.loginCheck(storeNumber, employeeID)) {

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Login Successful!");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                while (loop) {
                    System.out.println("Here is our current store inventory: ");
                    storeInventory.displayInventory(); // Display the current store inventory
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                    System.out.println("What would you like to do?");
                    System.out.println("1. Search for a guitar");
                    System.out.println("2. Purchase a guitar");
                    System.out.println("3. Checkout");

                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    switch (choice) {
                        case 1: // Search for a guitar
                            System.out.println("Enter search criteria (e.g., brand, body, numberOfStrings):");
                            System.out.println("Type 'done' when finished.");

                            Map<String, Object> searchProperties = new HashMap<>();
                            while (true) {
                                System.out.print("Enter property key: ");
                                String key = scanner.nextLine().trim();
                                if (key.equalsIgnoreCase("done")) break;

                                System.out.print("Enter property value: ");
                                String value = scanner.nextLine().trim();

                                // Try to parse as an integer if applicable
                                Object finalValue;
                                try {
                                    finalValue = Integer.parseInt(value);
                                } catch (NumberFormatException e) {
                                    finalValue = value;
                                }

                                searchProperties.put(key, finalValue);
                            }

                            GuitarSpec searchSpec = new GuitarSpec(searchProperties);
                            List<Guitar> results = storeInventory.search(searchSpec);

                            if (!results.isEmpty()) {
                                System.out.println("Matching guitars:");
                                for (Guitar guitar : results) {
                                    System.out.println(guitar);
                                }
                            } else {
                                System.out.println("No guitars matched your criteria.");
                            }
                            break;

                        case 2: // Purchase a guitar
                            System.out.println("Enter the serial number of the guitar you want to purchase: ");
                            int serialNumber = scanner.nextInt();

                            if (storeInventory.checkSerial(serialNumber)) {
                                Guitar selectedGuitar = storeInventory.getGuitarBySerial(serialNumber);

                                if (selectedGuitar != null) {
                                    System.out.println("Guitar details:");
                                    System.out.println(selectedGuitar);
                                    System.out.println("Add guitar to cart? (Y/N)");
                                    String confirm = scanner.next().trim().toUpperCase();

                                    if (confirm.equals("Y")) {
                                        storeInventory.updateInventory(serialNumber);
                                        cart.addToCart(selectedGuitar);
                                        System.out.println("Guitar added to cart!");
                                    }
                                }
                            } else {
                                System.out.println("The entered serial number does not exist.");
                            }
                            break;

                        case 3: // Exit
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("Checking out...");
                            cart.displayCart(); // Display the cart contents

                            float subTotal = cart.calculateSubTotal();
                            float tax = cart.calculateTax(subTotal);
                            float total = cart.calculateTotal(subTotal, tax);

                            System.out.printf("Subtotal: $%.2f%n", subTotal);
                            System.out.printf("Tax: $%.2f%n", tax);
                            System.out.printf("Total: $%.2f%n", total);

                            System.out.println("Please enter the amount of cash you are paying with:");
                            float cashProvided = scanner.nextFloat();

                            float change = cart.cashOut(cashProvided);
                            if (change >= 0) {
                                System.out.printf("Transaction successful! Your change is: $%.2f%n", change);
                                loop = false; // End the program loop
                            } else {
                                System.out.println("Insufficient cash provided. Please try again.");
                            }
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                }
            } else {
                System.out.println("The Store Number or Employee ID are incorrect!");
                System.out.println("Please try again!");
            }
        }

        System.out.println("Thank you for visiting our shop.");
    }
}
