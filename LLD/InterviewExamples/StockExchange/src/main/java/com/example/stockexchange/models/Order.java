package com.example.stockexchange.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Builder.Default
    private String orderId = UUID.randomUUID().toString();

    @NotNull(message = "User ID is required")
    private String userId;

    @NotNull(message = "Order type is required")
    private OrderType orderType;

    @NotNull(message = "Stock symbol is required")
    private String stockSymbol;

    @NotNull(message = "Stock quantity is required")
    private int quantity;

    @NotNull(message = "Price is required")
    private double price;

    @Builder.Default
    private OrderStatus orderStatus = OrderStatus.ACCEPTED;

    @Builder.Default
    private int remainingQuantity = 0;

    @Builder.Default
    private int filledQuantity = 0;

    @Builder.Default
    private LocalDateTime orderAcceptedTimeStamp = LocalDateTime.now();
}
