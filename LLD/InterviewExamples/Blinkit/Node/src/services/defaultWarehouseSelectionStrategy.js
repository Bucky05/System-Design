const Warehouse = require('../models/warehouse');
const Inventory = require('../models/inventory');


class DefaultWarehouseSelectionStrategy {
    warehouse = new this.Warehouse(
        new Inventory({"1":3 , "2":6})
    )
    getWarehouse(itemList) {
        return warehouse
    }
}