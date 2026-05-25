package com.example.stockexchange.controllers;

import com.example.stockexchange.dto.OrderRequest;
import com.example.stockexchange.models.Order;
import com.example.stockexchange.services.TradingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/v1/trading")
@RequiredArgsConstructor
public class TradingController {

    private final TradingService tradingService; // violates DI// fix it

    @PostMapping("/orders")
    public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest orderRequest) {
        Order order = tradingService.placeOrder(orderRequest);

        return ResponseEntity.ok(order);
    }

    @GetMapping("/orderBook/{symbol}")
    public ResponseEntity<List<Order>> getOrderBook(@PathVariable String symbol) {
        List<Order> orderBook = tradingService.getOrderBook(symbol);

        return ResponseEntity.ok(orderBook);
    }
}
