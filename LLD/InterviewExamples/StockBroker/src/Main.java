import publishers.ExchangePublisher;
import publishers.IndianExchangePublisher;
import subscribers.StockSubscriber;
import subscribers.Subscriber;
import utils.Currency;
import utils.StockSymbol;
import utils.StockValue;
import utils.Value;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ExchangePublisher nse = new IndianExchangePublisher("NSE");
        ExchangePublisher bse = new IndianExchangePublisher("BSE");

        Subscriber s1 = new StockSubscriber();

        nse.subscribe(s1);
        bse.subscribe(s1);

        nse.notify(new Value(Currency.INR,100), StockSymbol.GOOGL, LocalDateTime.now());
        bse.notify(new Value(Currency.INR, 99), StockSymbol.AMAZ, LocalDateTime.now());
        s1.display();
        nse.notify(new Value(Currency.INR,190), StockSymbol.GOOGL, LocalDateTime.of(1999,1,1,0,0));
        s1.display();

    }
}