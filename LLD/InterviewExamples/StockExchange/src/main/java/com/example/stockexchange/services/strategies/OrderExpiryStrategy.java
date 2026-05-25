package com.example.stockexchange.services.strategies;

import com.example.stockexchange.models.Order;

public interface OrderExpiryStrategy {

    boolean checkExpiry(Order order);
}
