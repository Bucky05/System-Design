package factories;

import models.config.ServerConfig;
import models.helper.TimeHelper;
import models.pricing.HourlyPricingStrategy;
import models.pricing.PricingStrategy;
import models.tickets.Ticket;

public class PricingStrategyFactory {

    public static PricingStrategy createHourlyPricingStrategy(Ticket ticket) {
        return new HourlyPricingStrategy(
                ServerConfig.PRICE_PER_HOUR,
                TimeHelper.convertMillisecondsToHours(ticket.getExitTime().get() - ticket.getEntryTime())
        );
    }
}
