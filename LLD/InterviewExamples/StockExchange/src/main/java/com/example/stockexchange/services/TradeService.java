package com.example.stockexchange.services;

import com.example.stockexchange.models.Trade;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class TradeService {

    private final Map<String, Trade> tradeMap = new ConcurrentHashMap<>();

    public Trade saveTrade(Trade trade) {
        tradeMap.put(trade.getTradeId(), trade);
        return trade;
    }

    public Optional<Trade> getTrade(String id) {
        return Optional.ofNullable(tradeMap.get(id));
    }

    public List<Trade> getTradeByStockSymbol(String symbol) {
        return tradeMap.values().stream().filter(trade -> trade.getStockSymbol().equals(symbol)).collect(Collectors.toList());
    }
}
