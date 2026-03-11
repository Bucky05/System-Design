package com.example.stockexchange.models;

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
public class Stock {

    @Builder.Default
    private String stockId = UUID.randomUUID().toString();

    @NotNull(message = "Stock name is required")
    private String stockName;

    @NotNull(message = "Stock symbol is required")
    private StockSymbol stockSymbol;

    @NotNull(message =  "Stock price is required")
    private double stockPrice;
}
