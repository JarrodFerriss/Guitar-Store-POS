package org.example.objects;

public class ElectricGuitar extends Guitar {
    // Updated constructor to accept a GuitarSpec
    public ElectricGuitar(int serialNumber, float price, int numberInStock, GuitarSpec spec) {
        super(serialNumber, price, numberInStock, spec);
    }

    @Override
    public String toString() {
        return "Electric Guitar - Serial: " + this.getSerialNumber() +
                ", Price: $" + this.getPrice() +
                ", In Stock: " + this.getNumberInStock() +
                ", Specifications: " + this.getSpec().getProperties();
    }
}
