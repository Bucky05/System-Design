package services.filterServices;

import models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ORFilterCriteria implements Criteria{

    private final List<Criteria> criteriaList;

    public ORFilterCriteria(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public List<Product> satisfy(List<Product> p) {
        // go to every product

        // make it pass through criteria until one passses



        return p.stream()
                .filter(
                        product -> criteriaList.stream().anyMatch(
                                criteria -> !criteria.satisfy(List.of(product)).isEmpty()
                        )
                ).collect(Collectors.toList());
    }
}