const Product = require("../models/product");

const productList = [
    new Product("Shirt","CLOTHING",100),
    new Product("Vicks","PHARMECEUTICAL",30)
]


module.exports = {
    addProduct : (product) => productList.push(product),
    getProductList : () => productList
}