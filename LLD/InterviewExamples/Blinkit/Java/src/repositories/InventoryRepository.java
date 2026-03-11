package repositories;

import models.Inventory;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryRepository {

    List<Inventory> inventoryList ;

    public InventoryRepository(List<Inventory> inventoryList) {
        //can implement prototype method to create deep copy;
        this.inventoryList = inventoryList;
    }

    public void updateInventory(String itemName, String warehouseId, int updateQuantityBy) {
        for(Inventory inventory : inventoryList) {
            if(inventory.getProduct().getName().equals(itemName) && inventory.getWarehouse().getId().equals(warehouseId)) {
                int updatedQuantity = inventory.getQuantity() + updateQuantityBy;
                if(updatedQuantity == 0) {
                    inventoryList.remove(inventory);
                } else {
                    inventory.setQuantity(updatedQuantity);
                }
            }
        }
    }

    public List<Inventory> getInventoryByWarehouseId(String id) {
        return inventoryList.stream()
                .filter((inventory ) -> inventory.getWarehouse().getId().equals(id)).collect(Collectors.toList());

    }
}
