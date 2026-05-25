package com.example.stockexchange.services.strategies.impl;

import com.example.stockexchange.models.Order;
import com.example.stockexchange.models.OrderStatus;
import com.example.stockexchange.services.strategies.OrderExpiryStrategy;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class IntradayOrderExpiryStrategy implements OrderExpiryStrategy {

    @Override
    public boolean checkExpiry(Order order) {

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime orderAcceptedTimeStamp = order.getOrderAcceptedTimeStamp();
        if(now.isAfter(LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),15,30)) && orderAcceptedTimeStamp.isBefore(LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 15, 30))) {
            order.setOrderStatus(OrderStatus.EXPIRED);
            return true;
        }
        return false;

    }
}
