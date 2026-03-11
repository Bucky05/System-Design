package services;

import models.*;
import repositories.OrderRepository;
import repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderService {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public String placeOrder(Map<String,Integer> itemMap, WarehouseService warehouseService) {


        Warehouse warehouse = warehouseService.getWarehouse(itemMap,"Mumbai");
        warehouseService.updateInventory(itemMap,warehouse.getId(),false);

        List<OrderItem> orderItemList = new ArrayList<>();

        for(Map.Entry<String,Integer> item : itemMap.entrySet()) {
            Product product = productRepository.getProductByName(item.getKey());
            orderItemList.add(new OrderItem(product,item.getValue()));
        }
        Order order = new Order(orderItemList);

        orderRepository.getOrderList().add(order);

        return order.getId();
    }

    public void updateOrder(String orderId, Map<String,Integer> itemMap){
        Order order = orderRepository.getOrderById(orderId);
        // can be used state pattern here
        if(order.getStatus() == OrderStatus.ACCEPTED) {

            for(Map.Entry<String,Integer> item : itemMap.entrySet()) {

                OrderItem orderItem  = order.getOrderItemByProductName(item.getKey());

                orderItem.setQuantity(item.getValue());
            }
        } else {
            throw new IllegalStateException("Cannot modify order in current state. Current state: "+order.getStatus().toString());
        }
    }

    public void cancelOrder(String orderId){
        Order order = orderRepository.getOrderById(orderId);
        if(order.getStatus() == OrderStatus.ACCEPTED || order.getStatus() == OrderStatus.OUT_FOR_DELIVERY) {
            order.setOrderStatus(OrderStatus.CANCELLED);
        } else {
            throw new IllegalStateException("Cannot cancel in current state. Current state: "+order.getStatus().toString());
        }
    }

    public String getOrderStatus(String orderId) {
        Order order = orderRepository.getOrderById(orderId);

        return order.getStatus().toString();
    }
}
