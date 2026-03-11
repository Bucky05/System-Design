package repositories;

import models.Warehouse;

import java.util.List;

public class WarehouseRepository {

    private List<Warehouse> warehouseList;

    public WarehouseRepository(List<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }

    public List<Warehouse> getWarehouseList() {
        return this.warehouseList;
    }
}
