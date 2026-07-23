package org.example.repositories;

import org.example.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    List<Customer> customers;

    public CustomerRepository() {
        this.customers = new ArrayList<>();
    }

    public void add(Customer customer) {
        this.customers.add(customer);
    }
}
