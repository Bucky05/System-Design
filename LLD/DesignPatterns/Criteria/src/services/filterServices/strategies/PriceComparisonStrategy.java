package services.filterServices.strategies;

public interface PriceComparisonStrategy {

    boolean compare(double productPrice, double filterPrice);
}
