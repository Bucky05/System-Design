package models.pricing;

public class HourlyPricingStrategy implements PricingStrategy{

    private final float pricePerHour;
    private long numberOfHours;
    private final PricingStrategyType type;
    public HourlyPricingStrategy(float pricePerHour) {
        this.pricePerHour = pricePerHour;
        this.numberOfHours = 1;
        this.type = PricingStrategyType.HOURLY;
    }

    public HourlyPricingStrategy(float pricePerHour, long numberOfHours) {
        this.numberOfHours = numberOfHours;
        this.pricePerHour = pricePerHour;
        this.type = PricingStrategyType.HOURLY;
    }
    @Override
    public long calculatePrice() {
        return (long)pricePerHour*numberOfHours;
    }

    public void setNumberOfHours(long numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    @Override
    public PricingStrategyType getPricingStrategyType() {
        return type;
    }
}
