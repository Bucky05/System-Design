package com.example.stockexchange.services.strategies.impl;

import com.example.stockexchange.models.Order;
import com.example.stockexchange.models.OrderStatus;
import com.example.stockexchange.models.OrderType;
import com.example.stockexchange.models.Trade;
import com.example.stockexchange.services.strategies.OrderMatchingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Component
public class FIFOMatchingStrategy implements OrderMatchingStrategy {
    @Override
    public String getStrategyName() {
        return "";
    }

    @Override
    public List<Trade> matchOrders(Order newOrder, List<Order> existingOrderList) {
        if(newOrder.getOrderType() == OrderType.BUY) {
            return matchBuyOrder(newOrder,existingOrderList);
        } else {
            return matchSellOrder(newOrder,existingOrderList);
        }
    }

    private List<Trade> matchBuyOrder(Order buyOrder, List<Order> existingOrderList) {
        List<Trade> trades = new ArrayList<>();

        List<Order> matchingSellOrders = existingOrderList.stream()
                .filter(order -> {
                    return (
                            (order.getOrderType() == OrderType.SELL) &&
                                    order.getStockSymbol().equals(buyOrder.getStockSymbol()) &&
                                    (order.getPrice() <= buyOrder.getPrice()) &&
                                    (order.getOrderStatus() == OrderStatus.ACCEPTED)
                    );

                })
                .sorted((order1,order2) -> {
                    if(order1.getPrice() == order2.getPrice()) {
                        return order1.getOrderAcceptedTimeStamp().compareTo(order2.getOrderAcceptedTimeStamp());
                    } else {
                        return Double.compare(order1.getPrice(), order2.getPrice());
                    }
                })
                .toList();


        int remainingQuantity = buyOrder.getRemainingQuantity();

        for(Order order : matchingSellOrders) {
            if(remainingQuantity <= 0) break;

            int tradeQuantity = Math.min(remainingQuantity,order.getRemainingQuantity());

            Trade trade = Trade.builder().buyOrderId(buyOrder.getOrderId())
                    .sellOrderId(order.getOrderId())
                    .stockSymbol(buyOrder.getStockSymbol())
                    .quantity(tradeQuantity)
                    .price(order.getPrice())
                    .build();

            trades.add(trade);

            buyOrder.setFilledQuantity(buyOrder.getFilledQuantity() + tradeQuantity);
            order.setFilledQuantity(order.getFilledQuantity() + tradeQuantity);
            order.setRemainingQuantity(order.getRemainingQuantity() - tradeQuantity);
            remainingQuantity -= tradeQuantity;

            log.info("Trade: {} - {} - {} - {} -{} -{}",trade.getTradeId(),trade.getBuyOrderId(),trade.getSellOrderId(),trade.getQuantity(),trade.getPrice(),remainingQuantity);
        }

        buyOrder.setRemainingQuantity(remainingQuantity);


        return trades;
    }

    private List<Trade> matchSellOrder(Order sellOrder, List<Order> existingOrderList) {
        List<Trade> trades = new ArrayList<>();

        List<Order> matchingOrder = existingOrderList.stream()
                .filter(order -> {
                    return (
                            (order.getOrderType() == OrderType.BUY) &&
                                    order.getStockSymbol().equals(sellOrder.getStockSymbol()) &&
                                    (order.getPrice() >= sellOrder.getPrice()) &&
                                    (order.getOrderStatus() == OrderStatus.ACCEPTED)
                    );

                })
                .sorted((order1,order2) -> {
                    if(order1.getPrice() == order2.getPrice()) {
                        return order1.getOrderAcceptedTimeStamp().compareTo(order2.getOrderAcceptedTimeStamp());
                    } else {
                        return Double.compare(order2.getPrice(), order1.getPrice());
                    }
                })
                .toList();


        int remainingQuantity = sellOrder.getRemainingQuantity();

        for(Order order : matchingOrder) {
            if(remainingQuantity <= 0) break;

            int tradeQuantity = Math.min(remainingQuantity,order.getRemainingQuantity());

            Trade trade = Trade.builder().sellOrderId(sellOrder.getOrderId())
                    .buyOrderId(order.getOrderId())
                    .quantity(tradeQuantity)
                    .price(order.getPrice())
                    .build();

            trades.add(trade);

            sellOrder.setFilledQuantity(sellOrder.getFilledQuantity() + tradeQuantity);
            order.setFilledQuantity(order.getFilledQuantity() + tradeQuantity);
            order.setRemainingQuantity(order.getRemainingQuantity() - tradeQuantity);
            remainingQuantity -= tradeQuantity;

            log.info("Trade: {} - {} - {} - {} -{} -{}",trade.getTradeId(),trade.getBuyOrderId(),trade.getSellOrderId(),trade.getQuantity(),trade.getPrice(),remainingQuantity);
        }

        sellOrder.setRemainingQuantity(remainingQuantity);


        return trades;
    }

}
