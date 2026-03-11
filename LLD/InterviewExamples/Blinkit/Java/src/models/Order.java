package models;

import java.util.List;
import java.util.UUID;

public class Order {

    private String id;
    private List<OrderItem> orderItemList;
    private OrderStatus status;

    public Order(List<OrderItem> orderItemList) {
        id = UUID.randomUUID().toString();
        this.orderItemList = orderItemList;
        this.status = OrderStatus.ACCEPTED;
    }

    public String getId() {
        return this.id;
    }

    public List<OrderItem> getItemList() {
        return this.orderItemList;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public OrderItem getOrderItemByProductName(String productName) {
        for(OrderItem item : orderItemList) {
            if(item.getProduct().getName().equals(productName)) {
                return item;
            }
        }

        return null;
    }
    public void setOrderStatus(OrderStatus status) {
        this.status = status;
    }
}
