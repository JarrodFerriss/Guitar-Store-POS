package org.example;

// Program Name: Guitar Store POS - Store Inventory
// Program Purpose: Manage the store inventory and handle user input
// Author: Jarrod Ferriss
// Date: 2024-09-22

import org.example.objects.AcousticGuitar;
import org.example.objects.ElectricGuitar;
import org.example.objects.Guitar;
import org.example.objects.GuitarSpec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreInventory {

        //Initialize the arrays for the store inventory
        private List<Guitar> inventory = new ArrayList<>();

        //Create guitar objects
        public void initializeInventory() {
                // Electric Guitar 1
                Map<String, Object> electricProperties1 = new HashMap<>();
                electricProperties1.put("brand", "Ibanez");
                electricProperties1.put("body", "Stratocaster");
                electricProperties1.put("numberOfStrings", 6);
                electricProperties1.put("numberOfFrets", 24);
                inventory.add(new ElectricGuitar(8675309, 699.99f, 3, new GuitarSpec(electricProperties1)));

                // Electric Guitar 2
                Map<String, Object> electricProperties2 = new HashMap<>();
                electricProperties2.put("brand", "Gibson");
                electricProperties2.put("body", "Les Paul");
                electricProperties2.put("numberOfStrings", 6);
                electricProperties2.put("numberOfFrets", 22);
                inventory.add(new ElectricGuitar(8675308, 2499.99f, 2, new GuitarSpec(electricProperties2)));

                // Electric Guitar 3
                Map<String, Object> electricProperties3 = new HashMap<>();
                electricProperties3.put("brand", "Fender");
                electricProperties3.put("body", "Stratocaster");
                electricProperties3.put("numberOfStrings", 6);
                electricProperties3.put("numberOfFrets", 21);
                inventory.add(new ElectricGuitar(8675307, 1199.99f, 3, new GuitarSpec(electricProperties3)));

                // Acoustic Guitar 1
                Map<String, Object> acousticProperties1 = new HashMap<>();
                acousticProperties1.put("brand", "Martin");
                acousticProperties1.put("body", "D-28");
                acousticProperties1.put("numberOfStrings", 6);
                acousticProperties1.put("numberOfFrets", 20);
                inventory.add(new AcousticGuitar(112233, 2999.99f, 2, new GuitarSpec(acousticProperties1)));

                // Acoustic Guitar 2
                Map<String, Object> acousticProperties2 = new HashMap<>();
                acousticProperties2.put("brand", "Taylor");
                acousticProperties2.put("body", "114ce");
                acousticProperties2.put("numberOfStrings", 6);
                acousticProperties2.put("numberOfFrets", 20);
                inventory.add(new AcousticGuitar(223344, 999.99f, 2, new GuitarSpec(acousticProperties2)));

                // Acoustic Guitar 3
                Map<String, Object> acousticProperties3 = new HashMap<>();
                acousticProperties3.put("brand", "Yamaha");
                acousticProperties3.put("body", "FG800");
                acousticProperties3.put("numberOfStrings", 6);
                acousticProperties3.put("numberOfFrets", 20);
                inventory.add(new AcousticGuitar(334455, 199.99f, 4, new GuitarSpec(acousticProperties3)));
        }


        //Display Inventory
        public void displayInventory() {
                for (Guitar guitar : inventory) {
                        System.out.println(guitar);
                }
        }

        //Get a guitar by given serial
        public Guitar getGuitarBySerial(int serialNumber) {
                for (Guitar guitar : inventory) {
                        if (guitar.getSerialNumber() == serialNumber) {
                                return guitar;
                        }
                }
                return null;
        }

        //Check the given serial number
        public boolean checkSerial(int serialNumber) {
                return getGuitarBySerial(serialNumber) != null;
        }

        //Remove a selected guitar from the inventory
        public void updateInventory(int serialNumber) {
                Guitar guitar = getGuitarBySerial(serialNumber);
                if (guitar != null && guitar.getNumberInStock() > 0) {
                        guitar.setNumberInStock(guitar.getNumberInStock() - 1);
                }
        }

        // Search for guitars based on dynamic criteria
        public List<Guitar> search(GuitarSpec searchSpec) {
                List<Guitar> matchingGuitars = new ArrayList<>();
                for (Guitar guitar : inventory) {
                        // Use the GuitarSpec.matches method to compare specs
                        if (guitar.getSpec().matches(searchSpec)) {
                                matchingGuitars.add(guitar);
                        }
                }
                return matchingGuitars;
        }
}
