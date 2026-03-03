import models.Brand;
import models.Category;
import models.Product;
import services.filterServices.*;
import services.filterServices.factories.PriceComparisonStrategyFactory;
import services.filterServices.utils.Operators;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Brand b1 = new Brand("Apple");
        Brand b2 = new Brand("Samsung");
        Brand b3 = new Brand("Oneplus");

        Category c1 = new Category("Electronics");

        Product p1 = new Product("IPhone 17", 79999.99,b1,c1);
        Product p2 = new Product("Galaxy S25", 100000.99,b2,c1);
        Product p3 = new Product("OnePlus 14", 79999.99,b3,c1);

        List<Product> products = List.of(p1,p2,p3);

        Criteria cr1 = new BrandFilterCriteria("Apple");
        Criteria cr2 = new BrandFilterCriteria("Samsung");

        Criteria orCriteria = new ORFilterCriteria(List.of(cr1,cr2));

        Criteria priceFilterCriteria = new PriceFilterCriteria(99999, PriceComparisonStrategyFactory.create(Operators.LESS_THAN));
        List<Product> orFiltered = orCriteria.satisfy(products);

        orFiltered.stream()
                .forEach(product -> System.out.println(product.getName()));



        Criteria andCriteria = new ANDFilterCriteria(List.of(orCriteria,priceFilterCriteria));

        andCriteria.satisfy(products)
                .stream()
                .forEach(product -> System.out.println(product.getName()));
    }
}