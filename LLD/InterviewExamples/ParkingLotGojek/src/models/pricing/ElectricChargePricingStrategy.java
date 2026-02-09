package models.pricing;

public class ElectricChargePricingStrategy implements PricingStrategy{

    private final long price;
    private final PricingStrategyType type;
    public ElectricChargePricingStrategy(long price) {
        this.price=price;
        this.type = PricingStrategyType.CONSTANT;
    }
    @Override
    public long calculatePrice() {
        return price;
    }

    @Override
    public PricingStrategyType getPricingStrategyType() {
        return type;
    }
}
