package services.filterServices;

import models.Product;
import services.filterServices.strategies.PriceComparisonStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class PriceFilterCriteria implements Criteria{


    private final double price;
    private final PriceComparisonStrategy priceComparisonStrategy;

    public PriceFilterCriteria(double price, PriceComparisonStrategy priceComparisonStrategy) {
        this.price = price;
        this.priceComparisonStrategy = priceComparisonStrategy;
    }

    @Override
    public List<Product> satisfy(List<Product> p) {
        return p.stream()
                .filter((product) -> priceComparisonStrategy.compare(product.getPrice(),price))
                .collect(Collectors.toList());
    }
}
