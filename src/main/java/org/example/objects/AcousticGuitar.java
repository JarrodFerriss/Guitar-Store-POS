package org.example.objects;

public class AcousticGuitar extends Guitar {
    // Updated constructor to accept a GuitarSpec
    public AcousticGuitar(int serialNumber, float price, int numberInStock, GuitarSpec spec) {
        super(serialNumber, price, numberInStock, spec);
    }

    @Override
    public String toString() {
        return "Acoustic Guitar - Serial: " + this.getSerialNumber() +
                ", Price: $" + this.getPrice() +
                ", In Stock: " + this.getNumberInStock() +
                ", Specifications: " + this.getSpec().getProperties();
    }
}
