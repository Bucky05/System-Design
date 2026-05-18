package com.example.stockexchange.data;

import com.example.stockexchange.models.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderBook {

    void addOrder(Order order);

    void removeOrder(String orderId, String stockSymbol);

    boolean updateOrder(Order updatedOrder);

    Optional<Order> getOrderBySymbol(String symbol);

    List<Order> getOrders(String symbol);

    Optional<Order> getOrderById(String id);

}
