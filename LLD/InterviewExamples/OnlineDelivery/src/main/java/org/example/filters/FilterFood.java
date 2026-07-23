package org.example.filters;

import org.example.models.Dish;

import java.util.List;

public interface FilterFood {

    List<Dish> filter(List<Dish> dishes, String condition);
}
