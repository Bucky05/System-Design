package services.filterServices;

import models.Product;

import java.util.List;

public interface Criteria {

    List<Product> satisfy(List<Product> p);
}
