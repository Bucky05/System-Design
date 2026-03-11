package models;

public class Inventory {

    private Product product;
    private Warehouse warehouse;
    private int quantity;

    public Inventory(Product product, Warehouse warehouse, int quantity) {
        this.product = product;
        this.warehouse = warehouse;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
