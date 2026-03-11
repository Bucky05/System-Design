package com.example.stockexchange.exceptions;

public class InvalidOrderException extends TradingException{

    public InvalidOrderException(String message) {
        super("Invalid order: " + message);
    }
}
