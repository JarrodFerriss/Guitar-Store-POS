package org.example.objects;

public class Guitar {
    private int serialNumber;       // Unique identifier for each guitar
    private float price;            // Price of the guitar
    private int numberInStock;      // Quantity available in inventory
    private GuitarSpec spec;        // Dynamic specifications

    // Constructor
    public Guitar(int serialNumber, float price, int numberInStock, GuitarSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.numberInStock = numberInStock;
        this.spec = spec;
    }

    // Getters
    public int getSerialNumber() {
        return serialNumber;
    }

    public float getPrice() {
        return price;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
    }

    public GuitarSpec getSpec() {
        return spec;
    }

    @Override
    public String toString() {
        return "Serial: " + serialNumber +
                ", Price: $" + price +
                ", In Stock: " + numberInStock +
                ", Specifications: " + spec.getProperties();
    }
}
