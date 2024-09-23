package org.example.objects;

// Program Name: Employee Object Class
// Program Purpose: Declare the Employee Object Class
// Author Name: Jarrod Ferriss
// Date: 2024-09-18

public class Employee {

    //Properties
    public String name;
    public int age;
    public String position;
    public int id;
    public float wagePerHour;

    //Constructor
    public Employee(String name, int age, String position, int id, float wagePerHour) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.id = id;
        this.wagePerHour = wagePerHour;
    }

    //Getters Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getWagePerHour() {
        return wagePerHour;
    }

    public void setWagePerHour(float wagePerHour) {
        this.wagePerHour = wagePerHour;
    }

    //toString
    @Override
    public String toString() {
        return name + " is a " + position + " and earns " + wagePerHour + " per hour.";
    }
}
