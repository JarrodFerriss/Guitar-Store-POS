package org.example.objects;

// Program Name: Electric Guitar Child Class
// Program Purpose: Declare the child Electric Guitar class
// Author Name: Jarrod Ferriss
// Date: 2024-09-22

public class ElectricGuitar extends Guitar {

    //Electric guitar inherits all properties
    public ElectricGuitar(String brand, String body, int numberOfStrings, int numberOfFrets, int serialNumber,
                          float price, int numberInStock) {

        super(brand, body, numberOfStrings, numberOfFrets, serialNumber, price, numberInStock);
    }

    @Override
    public String toString() {
        return "This is a(n) " + this.getBrand() + " guitar with " + this.getNumberOfStrings() + " strings, " +
                this.getNumberOfFrets() + " frets, and a price of $" + this.getPrice() + ". The serial number for " +
                "this guitar is " + this.getSerialNumber() + " and we have " + this.getNumberInStock() + " in stock.";
    }
}
