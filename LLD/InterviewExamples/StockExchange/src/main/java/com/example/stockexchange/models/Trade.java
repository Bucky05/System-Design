package com.example.stockexchange.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Trade {

    @Builder.Default
    private String tradeId = UUID.randomUUID().toString();

    @NotNull(message = "Buy order ID is required")
    private String buyOrderId;

    @NotNull(message = "Sell order ID is required")
    private String sellOrderId;

    @NotNull(message =  "Stock ID is required")
    private String stockId;

    @NotNull(message = "Stock quantity is required")
    private int quantity;

    @NotNull(message = "Stock price is required")
    private double price;
}
