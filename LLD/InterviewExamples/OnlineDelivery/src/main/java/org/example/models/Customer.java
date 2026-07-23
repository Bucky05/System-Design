package org.example.models;

import org.example.models.valueObjects.Location;

public class Customer {

    int id;
    String name;
    Location lastLocation;

    public Customer(int id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.lastLocation = location;
    }



}
