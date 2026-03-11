package com.example.stockexchange.exceptions;


public class UserNotFoundException extends TradingException{

    public UserNotFoundException(String userId) {
        super("User not found with user ID: "+ userId);
    }
}
