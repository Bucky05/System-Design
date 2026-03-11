package com.example.stockexchange.services.strategies;

import com.example.stockexchange.models.Order;
import com.example.stockexchange.models.Trade;

import java.util.List;

public interface OrderMatchingStrategy {

    String getStrategyName();

    List<Trade> matchOrders(Order newOrder, List<Order> existingOrderList);
}
