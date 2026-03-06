package subscribers;

import utils.StockSymbol;
import utils.StockValue;
import utils.Value;

import java.time.LocalDateTime;

public interface Subscriber {

    void update(Value value, StockSymbol symbol, LocalDateTime time);
    void display();
}
