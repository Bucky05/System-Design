const { randomUUID } = require('crypto')
const OrderItem = require('.orderItem');

class Order {

    #id
    #orderItemList
    #orderStatus
    constructor(orderItemList) {
        this.#id = randomUUID();
        this.#orderItemList = orderItemList;
        this.#orderStatus = "ACCEPTED"
    }

    getId() {
        return this.#id;
    }

    getOrderItemList() {
        //ideally should be created a deep copy
        return this.#orderItemList;
    }

    removeItem(itemName) {
        this.#orderItemList = this.#orderItemList.filter((item) => item.getProduct().getName().equals(itemName))
        console.log("Item removed");
    }

    updateItem(itemName, quantity) {
        
        for(let item of this.#orderItemList) {
            if(item.getProduct().getName().equals(itemName)) {
                item.setQuantity(quantity)
                break;
            }
        }
    }

    getOrderStatus() {
        return this.#orderStatus
    }

    updateOrderStatus(status) {
        this.#orderStatus = status
    }
}

module.exports = Order;