package org.example.models;

import org.example.models.valueObjects.Location;

public class DeliveryPartner {

    int id;
    String name;
    Vehicle vehicle;
    Location lastLocation;
    int rating;
    public DeliveryPartner(int id, String name, Vehicle vehicle, Location location) {
        this.id = id;
        this.name = name;
        this.vehicle = vehicle;
        this.lastLocation = location;
    }
}
