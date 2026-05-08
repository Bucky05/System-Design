package com.example.stockexchange.data.impl;

import com.example.stockexchange.data.IOrderBook;
import com.example.stockexchange.models.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class OrderBook implements IOrderBook {

    private final ConcurrentMap<String, List<Order>> orderBook ;
    private final ConcurrentMap<String, ReadWriteLock> symbolLocks;
    public OrderBook() {
        orderBook = new ConcurrentHashMap<>();
        symbolLocks = new ConcurrentHashMap<>();
    }
    @Override
    public void addOrder(Order order) {
        String stockSymbol = order.getStockSymbol();
        ReadWriteLock lock = getOrCreateLock(stockSymbol);

        lock.writeLock().lock();

        try {
            orderBook.computeIfAbsent(stockSymbol,k -> new ArrayList<>()).add(order);
            log.info("Order added to order book: {} - {} - {} - {} - {} - {}",order.getOrderId(), order.getUserId(), order.getStockSymbol(), order.getQuantity(), order.getPrice(), order.getFilledQuantity());
        } finally {
            lock.writeLock().unlock();
        }

    }

    @Override
    public void removeOrder(String orderId, String stockSymbol) {
        ReadWriteLock lock = getOrCreateLock(stockSymbol);

        lock.writeLock().lock();

        try {
            List<Order> orders = orderBook.get(stockSymbol);

            if(orders != null) {
                boolean removed = orders.removeIf(order -> order.getOrderId().equals(orderId));
                if(removed) {
                    log.info("Order removed from order book");

                } else {
                    log.info("Order not found in order book");
                }
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public boolean updateOrder(Order updatedOrder) {

        String stockSymbol = updatedOrder.getStockSymbol();

        ReadWriteLock lock = getOrCreateLock(stockSymbol);

        lock.writeLock();

        try {
            List<Order> orders = orderBook.get(stockSymbol);
            if(orders != null) {
                for(int i = 0 ; i < orders.size() ; i++) {
                    if(orders.get(i).getOrderId().equals(updatedOrder.getOrderId())) {
                        orders.set(i,updatedOrder);
                        log.info("Order updated in order book");
                        return true;
                    }
                }
            }
            return false;
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public Optional<Order> getOrderBySymbol(String symbol) {
        ReadWriteLock lock = getOrCreateLock(symbol);

        lock.readLock().lock();

        try {
            return orderBook.get(symbol).stream().findFirst();
        } finally {
            lock.readLock().unlock();
        }
    }



    private ReadWriteLock getOrCreateLock(String stockSymbol) {
        return symbolLocks.computeIfAbsent(stockSymbol,k -> new ReentrantReadWriteLock());
    }
}
