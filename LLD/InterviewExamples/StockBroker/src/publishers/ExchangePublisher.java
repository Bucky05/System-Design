package publishers;


import subscribers.Subscriber;
import utils.StockSymbol;
import utils.StockValue;
import utils.Value;

import java.time.LocalDateTime;

public interface ExchangePublisher {

    void subscribe(Subscriber s);
    void unsubscribe(Subscriber s);
    void notify(Value value, StockSymbol symbol, LocalDateTime time);
}
