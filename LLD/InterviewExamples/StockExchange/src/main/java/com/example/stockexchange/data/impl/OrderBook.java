package com.example.stockexchange.data.impl;

import com.example.stockexchange.data.IOrderBook;
import com.example.stockexchange.models.Order;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReadWriteLock;

public class OrderBook implements IOrderBook {

    private final ConcurrentMap<String, List<Order>> orderBook ;
    private final ConcurrentMap<String, ReadWriteLock> symbolLocks;
    public OrderBook() {
        orderBook = new ConcurrentHashMap<>();
        symbolLocks = new ConcurrentHashMap<>();
    }
    @Override
    public void addOrder(Order order) {

    }

    @Override
    public void removeOrder(String orderId) {

    }

    @Override
    public void updateOrder(Order updatedOrder) {

    }

    @Override
    public List<Order> getOrders(String stockSymbol) {
        return List.of();
    }

    @Override
    public Optional<Order> getOrderById(String orderId) {
        return Optional.empty();
    }
}
