package org.example;

// Program Name: Guitar Store POS - Login System
// Program Purpose: Check the entered credentials against credentials in the system
// Author: Jarrod Ferriss
// Date: 2024-09-22

import org.example.objects.Employee;
import org.example.objects.Store;

public class Login {

    //Login Check
    public Boolean loginCheck(int storeID, int employeeID) {

        //Instantiate storeInfo
        StoreInfo storeInfo = new StoreInfo();
        //Initialize store and employee information
        Store store = storeInfo.initializeStoreInfo();
        Employee employee = storeInfo.initializeEmployeeInfo();

        //Returns true if storeID and employeeID match
        return storeID == store.getStoreNumber() && employeeID == employee.getId();
    }
}
