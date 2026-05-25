package com.example.stockexchange.dto;

import com.example.stockexchange.models.OrderType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    @NotNull(message = "User ID is required")
    private String userId;

    @NotNull(message = "Order type is required")
    private OrderType orderType;

    @NotNull(message = "Stock Symbol is required")
    private String stockSymbol;

    @NotNull(message = "Quantity is required")
    private int quantity;

    @NotNull(message = "Price is required")
    private double price;
}
