package utils;

import subscribers.StockSubscriber;

import java.time.LocalDateTime;

public class StockValue {

    private final Value value;
    private final LocalDateTime time;

    public StockValue(Value value, LocalDateTime time) {
        this.value = value;
        this.time = time;
    }

    public Value getValue() {
        return value;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
