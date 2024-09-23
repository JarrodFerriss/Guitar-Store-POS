package org.example.objects;

// Program Name: Acoustic Guitar Child Class
// Program Purpose: Declare the child Acoustic Guitar class
// Author Name: Jarrod Ferriss
// Date: 2024-09-22

public class AcousticGuitar extends Guitar {

    //Acoustic guitar inherits all properties
    public AcousticGuitar(String brand, String body, int numberOfStrings, int numberOfFrets, int serialNumber,
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
