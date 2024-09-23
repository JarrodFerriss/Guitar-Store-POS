package org.example.objects;

// Program Name: Guitar Parent Class
// Program Purpose: Declare the parent guitar class {Will be split into Electric and Acoustic Child Classes}
// Author Name: Jarrod Ferriss
// Date: 2024-09-22

public class Guitar {

    //Properties
    String brand;
    String body;
    int numberOfStrings;
    int numberOfFrets;
    int serialNumber;
    float price;
    int numberInStock;

    //Constructor
    public Guitar(String brand, String body, int numberOfStrings, int numberOfFrets, int serialNumber,
                  float price, int numberInStock) {
        this.brand = brand;
        this.body = body;
        this.numberOfStrings = numberOfStrings;
        this.numberOfFrets = numberOfFrets;
        this.serialNumber = serialNumber;
        this.price = price;
        this.numberInStock = numberInStock;
    }

    //Getters Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    public int getNumberOfFrets() {
        return numberOfFrets;
    }

    public void setNumberOfFrets(int numberOfFrets) {
        this.numberOfFrets = numberOfFrets;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
    }
}
