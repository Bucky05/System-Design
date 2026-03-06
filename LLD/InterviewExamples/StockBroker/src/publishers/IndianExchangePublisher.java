package publishers;

import subscribers.Subscriber;
import utils.StockSymbol;
import utils.StockValue;
import utils.Value;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class IndianExchangePublisher implements ExchangePublisher{

    private final List<Subscriber> subscriberList;
    private final String exchangeName;

    public IndianExchangePublisher(String exchangeName){
        subscriberList = new ArrayList<>();
        this.exchangeName = exchangeName;
    }
    @Override
    public void subscribe(Subscriber s) {
        subscriberList.add(s);
    }

    @Override
    public void notify(Value value, StockSymbol symbol, LocalDateTime time) {
        subscriberList.forEach(subscriber -> subscriber.update(value,symbol,time));
    }

    @Override
    public void unsubscribe(Subscriber s) {
        subscriberList.remove(s);
    }

    public String getExchangeName() {
        return exchangeName;
    }
}
