package com.example.stockexchange.services;

import com.example.stockexchange.data.IOrderBook;
import com.example.stockexchange.models.Order;
import com.example.stockexchange.models.OrderStatus;
import com.example.stockexchange.models.OrderType;
import com.example.stockexchange.models.Trade;
import com.example.stockexchange.services.strategies.OrderMatchingStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);


    public Order placeOrder(Order order) {

            // TODO: Implement validations
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

    private void executeOrderMatch(Order newOrder) {
        String stockSymbol = newOrder.getStockSymbol();


        List<Order> existingOrders = orderBook.getOrders(stockSymbol);

        existingOrders = existingOrders.stream().filter(order -> !order.getOrderId().equals(newOrder
                .getOrderId())).collect(Collectors.toList());

        List<Trade> executedTrades = orderMatchingStrategy.matchOrders(newOrder, existingOrders);

        if(!executedTrades.isEmpty()) {
            for(Trade executedTrade : executedTrades) {
                // save trades in the db
            }

            orderBook.updateOrder(newOrder);

            for(Trade trade : executedTrades) {
                String otherOrderId = newOrder.getOrderType() == OrderType.BUY ? trade.getSellOrderId() : trade.getBuyOrderId();
                orderBook.getOrderById(otherOrderId).ifPresent(orderBook::updateOrder);
            }

            log.info("Order match successsfully");
        }


    }
}
