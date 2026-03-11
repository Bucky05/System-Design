package services;

import models.Inventory;
import models.Warehouse;
import repositories.InventoryRepository;
import services.strategies.WarehouseSelectionStrategy;

import java.util.List;
import java.util.Map;

public class WarehouseService {

    WarehouseSelectionStrategy warehouseSelectionStrategy;
    InventoryRepository inventoryRepository;
    public WarehouseService(WarehouseSelectionStrategy warehouseSelectionStrategy, InventoryRepository inventoryRepository) {
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
        this.inventoryRepository = inventoryRepository;
    }

    public Warehouse getWarehouse(Map<String,Integer> map, String city) {
        return warehouseSelectionStrategy.getWarehouse(map,city);
    }

    public void updateInventory(Map<String,Integer> map, String id,  boolean isAdded) {
        List<Inventory> inventoryList = inventoryRepository.getInventoryByWarehouseId(id);
        // add items if isAdded else remove
    }
}
