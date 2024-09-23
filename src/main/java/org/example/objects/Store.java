package org.example.objects;

// Program Name: Store Object Class
// Program Purpose: Declare the Store Object Class
// Author Name: Jarrod Ferriss
// Date: 2024-09-18

public class Store {

    //Properties
    public int storeNumber;
    public String address;
    public int phoneNumber;

    //Constructor
    public Store(int storeNumber, String address, int phoneNumber) {
        this.storeNumber = storeNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    //Getters Setters
    public int getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(int storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //toString
    @Override
    public String toString() {
        return "This store number is " + storeNumber + " and can be found at " + address + " or reached by calling " +
                phoneNumber;
    }
}
