package models;

public class Product {

    private String name;
    private Brand brand;
    private Category category;
    private double price;

    public Product(String name, double price, Brand brand, Category category) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.category = category;
    }

    public String getName() {
        return name;
    }


    public Brand getBrand() {
        return brand;
    }


    public Category getCategory() {
        return category;
    }


    public double getPrice() {
        return price;
    }

}
