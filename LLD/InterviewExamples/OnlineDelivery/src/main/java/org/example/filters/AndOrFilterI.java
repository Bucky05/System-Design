package org.example.filters;

import org.example.models.Dish;

import java.util.List;

public interface AndOrFilterI {

    List<Dish> filter(List<String> conditions, List<Dish> dishes);
}
