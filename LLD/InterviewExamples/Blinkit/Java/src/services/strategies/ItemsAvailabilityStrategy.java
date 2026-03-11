package services.strategies;

import models.Warehouse;
import repositories.WarehouseRepository;

import java.util.List;
import java.util.Map;

public class ItemsAvailabilityStrategy implements  WarehouseSelectionStrategy{

    private WarehouseRepository warehouseRepository;

    public ItemsAvailabilityStrategy(WarehouseRepository warehouseRepository) {
        this.warehouseRepository= warehouseRepository;
    }
    @Override
    public Warehouse getWarehouse(Map<String,Integer> map, String city) {
        return warehouseRepository.getWarehouseList().stream().findFirst().get();
    }
}
