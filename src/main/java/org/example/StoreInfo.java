package org.example;

// Program Name: Guitar Store POS - Store Info
// Program Purpose: Create the store and employee objects
// Author: Jarrod Ferriss
// Date: 2024-09-22

import org.example.objects.Employee;
import org.example.objects.Store;

public class StoreInfo {

    //Create the store object
    public Store initializeStoreInfo() {
        return new Store(659874, "567 Simcoe Street, Amherstburg",
                5553211);
    }

    //Create the employee object
    public Employee initializeEmployeeInfo() {
        return new Employee("Jarrod Ferriss", 28, "Sales",
                564231, 100.00f);
    }
}
