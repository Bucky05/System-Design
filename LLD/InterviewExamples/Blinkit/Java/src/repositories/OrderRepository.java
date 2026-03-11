package repositories;

import models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private final List<Order> orderList;

    public OrderRepository() {
        orderList = new ArrayList<>();
    }

    public List<Order> getOrderList() {
        return this.orderList;
    }

    public Order getOrderById(String id) {
        for(Order order : orderList) {
            if(order.getId().equals(id)) return order;
        }

        return null;
    }
}
