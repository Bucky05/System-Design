package repositories;

import models.Product;

import java.util.List;

public class ProductRepository {

    private List<Product> productList;

    public ProductRepository(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return this.productList;
    }

    public Product getProductByName(String name) {
        for(Product product : productList) {
            if(product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}
