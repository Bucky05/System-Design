const OrderItem = require('../models/orderItem');
const Order = require('../models/order');
const orderRepository = require('../repositories/orderRepository')


const defaultWarehouseSelectionStrategy = new DefaultWarehouseSelectionStrategy();
const warehouse = defaultWarehouseSelectionStrategy.getWarehouse(); 
module.exports = {
    placeOrder : (itemObject) => {
        const inventory = warehouse.getInventory().getProductMap();
        const orderItemList  = [];
        for(let obj in itemObject) {
            inventory[obj] -= itemObject[obj];
            orderItemList.push(new OrderItem())
        }

        const order = new Order(orderItemList);
        orderRepository.addOrder(order)
        return order.getId();

    },

    updateOrder : (orderId, itemObject) => {
        const order = orderRepository.getOrderById(orderId);
        if(order.getOrderStatus === "ACCEPTED") {
            for(let obj in itemObject) {
                order.updateItem(obj,itemObject[obj])
            }
        } else {
            throw new Error("Cannot update order, order already "+order.getOrderStatus());
        }

    },

    cancelOrder : (orderId) => {
        const order = orderRepository.getOrderById(orderId);

        if(order.getOrderStatus() in ["DELIVERED","CANCELLED"]) {
            throw new Error("Cannot cancel order, order already "+order.getOrderStatus())
        } else {
            order.updateOrderStatus("CANCELLED");
            const inventory = warehouse.getInventory
            for(const item of order.getItemList()) {
                inventory.updateItem(item.getProduct().getName(),-item.getQuantity())
            }
        }
    }
}