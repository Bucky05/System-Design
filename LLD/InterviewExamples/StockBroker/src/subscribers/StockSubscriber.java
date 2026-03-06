package subscribers;

import utils.StockSymbol;
import utils.StockValue;
import utils.Value;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class StockSubscriber implements Subscriber{

    Map<StockSymbol, StockValue> stockData;

    public StockSubscriber() {
        stockData = new HashMap<>();
    }

    @Override
    public void update(Value value, StockSymbol symbol, LocalDateTime time) {
        if(!stockData.containsKey(symbol)) {
            stockData.put(symbol,new StockValue(value,time));
        } else if(stockData.get(symbol).getTime().isBefore(time)) {
            stockData.put(symbol,new StockValue(value,time));
        }

        System.out.println("Updated stock data for "+symbol.toString());
    }

    @Override
    public void display() {
        for(Map.Entry<StockSymbol, StockValue> entry : stockData.entrySet()) {
            System.out.println("Stock: "+entry.getKey()+". Price: "+entry.getValue().getValue().getAmount());
        }
    }
}
