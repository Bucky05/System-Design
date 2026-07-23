package org.example.repositories;

import org.example.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {

    List<Restaurant> restaurants;

    public RestaurantRepository() {
        restaurants = new ArrayList<>();
    }
}
