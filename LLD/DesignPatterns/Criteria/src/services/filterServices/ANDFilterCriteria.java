package services.filterServices;

import models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ANDFilterCriteria implements Criteria{

    private final List<Criteria> criteriaList;

    public ANDFilterCriteria(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public List<Product> satisfy(List<Product> p) {
        // go to every product

        // make it pass through every criteria

        // add in answer only if it satisfies all

        return p.stream()
                .filter(
                        product -> criteriaList.stream().noneMatch(
                                criteria -> criteria.satisfy(List.of(product)).isEmpty()
                        )
                ).collect(Collectors.toList());
    }
}
