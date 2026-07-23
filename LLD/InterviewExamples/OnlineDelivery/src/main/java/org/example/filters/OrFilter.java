package org.example.filters;

import org.example.models.Dish;

import java.util.List;

public class OrFilter implements AndOrFilterI{

   public List<Dish> filter(List<String> conditions, List<Dish> dishes) {
       // apply or filter
       return null;
   }

}
