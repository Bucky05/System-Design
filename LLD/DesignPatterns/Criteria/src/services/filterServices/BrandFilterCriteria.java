package services.filterServices;

import models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class BrandFilterCriteria implements  Criteria{

    private final String brand;

    public BrandFilterCriteria(String brand) {
        this.brand = brand;
    }

    @Override

    public List<Product> satisfy(List<Product> p) {
        return p.stream()
                .filter(product -> product.getBrand().getName().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }
}
