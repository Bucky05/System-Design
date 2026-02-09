package models.pricing;

public class CarValetPricingStrategy implements PricingStrategy{

    private final long price;
    private final PricingStrategyType type;
    public CarValetPricingStrategy(long price) {
        this.price = price;
        type = PricingStrategyType.CONSTANT;
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
