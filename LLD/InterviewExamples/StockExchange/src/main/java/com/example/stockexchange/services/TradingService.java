package com.example.stockexchange.services;

import com.example.stockexchange.data.IOrderBook;
import com.example.stockexchange.dto.OrderRequest;
import com.example.stockexchange.models.Order;
import com.example.stockexchange.models.OrderStatus;
import com.example.stockexchange.models.OrderType;
import com.example.stockexchange.models.Trade;
import com.example.stockexchange.services.strategies.OrderMatchingStrategy;
import com.example.stockexchange.services.strategies.impl.IntradayOrderExpiryStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.stockexchange.services.strategies.OrderExpiryStrategy;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TradingService {

    private final IOrderBook orderBook;
    private final OrderMatchingStrategy orderMatchingStrategy;
    private final TradeService tradeService; // violated DP, FIX it
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private OrderExpiryStrategy orderExpiryStrategy = new IntradayOrderExpiryStrategy();

    public Order placeOrder(OrderRequest orderRequest) {

            // TODO: Implement validations
        Order order = Order.builder().userId(orderRequest.getUserId()).stockSymbol(orderRequest.getStockSymbol())
                .quantity(orderRequest.getQuantity()).
                price(orderRequest.getPrice()).build();
        order.setOrderAcceptedTimeStamp(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.ACCEPTED);

        order.setRemainingQuantity(order.getQuantity());

        orderBook.addOrder(order);

        CompletableFuture.runAsync(() -> {
            try {
                executeOrderMatch(order);
            } catch (Exception e) {log.error("Error executing order match", e);}
        },executorService);

        return order;
    }

    public List<Order> getOrderBook(String symbol) {return orderBook.getOrders(symbol);}
    private void executeOrderMatch(Order newOrder) {
        log.info("Executing order match for order: {}", newOrder.getOrderId());
        String stockSymbol = newOrder.getStockSymbol();


        List<Order> existingOrders = orderBook.getOrders(stockSymbol);

        existingOrders = existingOrders.stream().filter(order -> !orderExpiryStrategy.checkExpiry(order)).collect(Collectors.toList());
        existingOrders = existingOrders.stream().filter(order -> !order.getOrderId().equals(newOrder
                .getOrderId())).collect(Collectors.toList());

        log.info("Existing Order : {}", existingOrders.size());
        List<Trade> executedTrades = orderMatchingStrategy.matchOrders(newOrder, existingOrders);

        if(!executedTrades.isEmpty()) {
            for(Trade executedTrade : executedTrades) {
                tradeService.saveTrade(executedTrade);
            }

//            orderBook.updateOrder(newOrder);
//
//            for(Trade trade : executedTrades) {
//                String otherOrderId = newOrder.getOrderType() == OrderType.BUY ? trade.getSellOrderId() : trade.getBuyOrderId();
//                orderBook.getOrderById(otherOrderId).ifPresent(orderBook::updateOrder);
//            }

            log.info("Order match successsfully");
        }


    }
}
