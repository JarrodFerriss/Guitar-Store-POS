package org.example;

// Program Name: Guitar Store POS
// Program Purpose: Help manage sales of a guitar store
// Author: Jarrod Ferriss
// Date: 2024-09-22

import org.example.objects.Guitar;

import java.util.Scanner;

public class Main {

            /*
             - Develop a POS system for a client X
             - One type of product for sale, but plan on adding more X
             - One employee and one business location X
             - Client wants to accept cash payments and the program should calculate tax X

             Additional Requirements:
             - Each product will have a serial number X
             - Products may have different price, brand, and model X
             - A customer can purchase many goods with one transaction X
             - The system will display the product description, price and running total after
             each product is entered X
             - Once the products are selected, the program will show a list of products, the subtotal,
             taxes, and grand total X
             - The system should calculate the change for the transaction X
             - Enter a starting inventory during the initialization of the program X

         */

    public static void main(String[] args) {

        //Initialize loop sentinel variables
        boolean loop = true;
        String repeat;

        //Instantiate and initialize the storeInventory
        StoreInventory storeInventory = new StoreInventory();
        storeInventory.initializeInventory();

        //Begin the main program loop
        while (loop) {

            //Ask the user to login
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to our guitar shop!");
            System.out.println("Sign in to begin purchasing.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            System.out.println("Please enter the Store Number (659874): "); //Store number given
            int storeNumber = scanner.nextInt();

            System.out.println("Please enter Employee ID (564231): "); //Employee ID given
            int employeeID = scanner.nextInt();

            //Instantiate the login script
            Login login = new Login();

            //If the credentials are valid
            if (login.loginCheck(storeNumber, employeeID)) {

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Login Successful!");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                System.out.println("Here is our current store inventory: ");
                storeInventory.displayInventory(); //display the current store inventory
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                //Instantiate the cart
                Cart cart = new Cart();

                while (loop) {

                    //Ask the user to enter a serial number
                    System.out.println("Please enter the serial number of the item you would like to purchase: ");
                    int serialNumber = scanner.nextInt();

                    //If the serial number is valid
                    if (storeInventory.checkSerial(serialNumber)) {

                        //Save the selected guitar to a variable
                        Guitar selectedGuitar = storeInventory.getGuitarBySerial(serialNumber);

                        //If the guitar exists
                        if (selectedGuitar != null) {

                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            cart.addToCart(selectedGuitar); //Add the guitar to the cart
                            storeInventory.updateInventory(serialNumber); //Take the guitar out of stock

                            float subTotal = cart.subTotal(selectedGuitar); //Calculate the subtotal
                            System.out.println("The current subtotal is: $" + subTotal);

                            float tax = cart.tax(subTotal); //Calculate the tax
                            System.out.printf("The current tax is: $%.2f%n", tax);

                            float total = cart.total(subTotal, tax); //Calculate the total
                            System.out.printf("The current total with tax is: $%.2f%n", total);
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                            System.out.println("Would you like to continue shopping (Y/N): ");
                            repeat = scanner.next().trim().toUpperCase(); //Ask the user to continue?

                            //If the user wants to check out
                            if (repeat.equals("N")) {

                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                cart.displayCart(); //Display the contents of the cart
                                System.out.printf("The current total with tax is: $%.2f%n", total); //Display the total

                                System.out.println("Please enter how much cash you want to pay with: ");
                                float cashIn = scanner.nextFloat(); //Get the cash from the customer

                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.printf("Your change is: $%.2f%n", cart.cashout(total, cashIn)); //Calculate the change

                                loop = false; //End the program loop
                                scanner.close(); //Close the scanner
                            }
                        }
                    //If the serial number is invalid
                    } else {

                        //Inform the user and ask them to try again
                        System.out.println("That item does not exist.");
                        System.out.println("Please try again.");
                    }
                }
            //If the credentials are incorrect
            } else {

                //Inform the user and ask them to try again
                System.out.println("The Store Number or Employee ID are incorrect!");
                System.out.println("Please try again!");
            }
        }

        //Thank the user for shopping with us
        System.out.println("Thank you for visiting our shop.");
        System.out.println("Come back soon!");
    }
}