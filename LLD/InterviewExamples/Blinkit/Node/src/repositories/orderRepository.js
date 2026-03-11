const Order = require('../models/order')

const orderList = []

module.exports = {
    getOrderList : () => {
        return orderList;
    },

    addOrder : (order) => {
        orderList.add(order);
    },

    getOrderById : (id) => {
        return orderList.filter((order) => order.getId().equals(id))[0];
    }
}