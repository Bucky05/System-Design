package utils;

import java.time.LocalDateTime;

public class Value {

    private Currency currency;
    private double amount;

    public Value(Currency currency, double amount) {
        this.amount = amount;
        this.currency = currency;

    }

    public Currency getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

}
