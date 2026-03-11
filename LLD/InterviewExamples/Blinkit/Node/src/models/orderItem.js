class OrderItem {
    #product
    #quantity

    constructor(product, quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    getProduct() {
        return this.#product;
    }

    getQuantity() {
        return this.#quantity;
    }

    setQuantity(quantity) {
        this.#quantity = quantity;
    }
}

module.exports = OrderItem;