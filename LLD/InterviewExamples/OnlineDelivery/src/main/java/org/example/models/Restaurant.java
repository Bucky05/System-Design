package org.example.models;

import org.example.models.valueObjects.Location;

import java.util.*;

public class Restaurant {

    int id;
    String name;
    Location location;
    Map<String,Dish> menu;
    String gstNumber;
    int rating;
    public Restaurant(int id, String name, Location location, String gstNumber) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.menu = new HashMap<>();
        this.gstNumber = gstNumber;
    }


    public void addDish(Dish dish) {
        this.menu.put(dish.name,dish);
    }
}
