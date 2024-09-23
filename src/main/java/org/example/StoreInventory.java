package org.example;

// Program Name: Guitar Store POS - Store Inventory
// Program Purpose: Manage the store inventory and handle user input
// Author: Jarrod Ferriss
// Date: 2024-09-22

import org.example.objects.AcousticGuitar;
import org.example.objects.ElectricGuitar;
import org.example.objects.Guitar;

public class StoreInventory {

        //Initialize the arrays for the store inventory
        ElectricGuitar[] electricInventory = new ElectricGuitar[3];
        AcousticGuitar[] acousticInventory = new AcousticGuitar[3];

        //Create guitar objects
        public void initializeInventory() {
        //Populate the arrays with store inventory
        electricInventory[0] = new ElectricGuitar("Ibanez",
                "Stratocaster", 6, 24,
                8675309, 699.99f, 3);

        electricInventory[1] = new ElectricGuitar("Gibson",
                "Les Paul", 6, 22,
                8675308, 2499.99f, 2);

        electricInventory[2] = new ElectricGuitar("Fender",
                "Stratocaster", 6, 21,
                8675307, 1199.99f, 3);

        //Acoustic Guitars
        acousticInventory[0] = new AcousticGuitar("Martin",
                "D-28", 6, 20,
                112233, 2999.99f, 2);

        acousticInventory[1] = new AcousticGuitar("Taylor",
                "114ce", 6, 20,
                223344, 999.99f, 2);

        acousticInventory[2] = new AcousticGuitar("Yamaha",
                "FG800", 6, 20,
                334455, 199.99f, 4);
        }

        //Display Inventory
        public void displayInventory() {

                System.out.println("Electric Guitars: ");
                //For each electric guitar in the inventory
                for (ElectricGuitar electric : electricInventory) {
                        //toString
                        System.out.println(electric);
                }

                System.out.println("Acoustic Guitars: ");
                //For each acoustic guitar in the inventory
                for (AcousticGuitar acoustic : acousticInventory) {
                        //toString
                        System.out.println(acoustic);
                }
        }

        //Get a guitar by given serial
        public Guitar getGuitarBySerial(int enteredSerial) {

                //For electric guitars in the inventory
                for (ElectricGuitar electric : electricInventory) {
                        //If the serial number matches
                        if (enteredSerial == electric.getSerialNumber()) {
                                //Return that guitar
                                return electric;
                        }
                }

                //For acoustic guitars in the inventory
                for (AcousticGuitar acoustic : acousticInventory) {
                        //If the serial number matches
                        if (enteredSerial == acoustic.getSerialNumber()) {
                                //Return the guitar
                                return acoustic;
                        }
                }

                //If the guitar does not exist return null
                return null;
        }

        //Check the given serial number
        public Boolean checkSerial(int enteredSerial) {

                //Return true if the entered serial number is not null
                return getGuitarBySerial(enteredSerial) != null;
        }

        //Remove a selected guitar from the inventory
        public void updateInventory(int serialNumber) {

                //Search for the guitar
                Guitar guitar = getGuitarBySerial(serialNumber);

                //If it is found
                if (guitar != null) {

                        //Get the number currently in stock
                        int numberInStock = guitar.getNumberInStock();

                        //If its greater than 0
                        if (numberInStock > 0) {

                                //Decrease the number in stock by 1
                                guitar.setNumberInStock(numberInStock - 1);
                                //Print the guitar information
                                System.out.println("Purchase confirmed! Updated stock for " +
                                        guitar.getBrand() + " " + guitar.getBody() + ": " +
                                        guitar.getNumberInStock());
                        //If there are none in the inventory
                        } else {

                                //Let the user know
                                System.out.println("Currently out of stock!");
                                System.out.println("Come back soon!");
                        }
                }
        }
}
