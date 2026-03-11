const { randomUUID } = require('crypto')

class Warehouse {
    #id
    #city
    #inventory

    constructor(city,inventory) {
        this.#id = randomUUID();
        this.#city = city;
        this.#inventory = inventory;
    }

    getCity() {
        return this.#city;
    }

    getInventory() {
        return this.#inventory
    }
}