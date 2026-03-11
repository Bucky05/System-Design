package com.example.stockexchange.exceptions;


public class OrderNotFoundException extends TradingException{

    public OrderNotFoundException(String orderId) {
        super("Order not found with ID: "+orderId);
    }
}
