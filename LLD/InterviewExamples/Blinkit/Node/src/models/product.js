const { randomUUID } = require('crypto')

class Product {

    #id;
    #name;
    #category;
    #price;

    constructor(name,category,price) {
        this.#id = randomUUID()
        this.#name = name;
        this.#category = category;
        this.#price = price;
    }


    getName() {
        return this.#name;
    }

    getId() {
        return this.#id;
    }

    getCategory() {
        return this.#category;
    }

    getPrice() {
        return this.#price;
    }
}

module.exports = Product;