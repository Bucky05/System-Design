class Inventory {

    #productMap

    constructor(productMap) {
        this.#productMap = productMap
    }

    getProductMap() {
        return this.#productMap;
    }

    updateProduct(name, quantity) {
        this.#productMap[name] += quantity;
    }
}