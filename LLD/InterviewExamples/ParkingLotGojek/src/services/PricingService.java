package services;

import factories.PricingStrategyFactory;
import models.config.ServerConfig;
import models.helper.TimeHelper;
import models.pricing.HourlyPricingStrategy;
import models.pricing.PricingStrategy;
import models.pricing.PricingStrategyType;
import models.tickets.Ticket;

import java.util.List;

public class PricingService {

    public static long calculateParkingCharge(Ticket ticket) {
        long price = 0;
        for(PricingStrategy pricingStrategy : ticket.getPricingStrategyList()) {
            if(pricingStrategy.getPricingStrategyType().equals(PricingStrategyType.HOURLY)) {
                pricingStrategy = PricingStrategyFactory.createHourlyPricingStrategy(ticket);
            }
            price += pricingStrategy.calculatePrice();


        }
        System.out.println("Price Calculated: "+ price);
        return price;
    }
}
