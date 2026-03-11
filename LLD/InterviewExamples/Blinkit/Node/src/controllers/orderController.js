const router = require('express').Router();
const orderService = require('../services/orderService');
router.post('/',(req,res) => {
    const id = orderService.placeOrder(req.body.ItemList);
    res.json({"message":"Order placed successfully. Here is your order id: "+id});
})

router.patch('/',(req,res) => {
    const message = orderService.updateOrder(req.body.orderId,req.body.itemList);
    res.json({message})
})