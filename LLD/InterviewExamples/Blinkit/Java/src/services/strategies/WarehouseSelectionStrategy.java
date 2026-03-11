package services.strategies;

import models.Warehouse;

import java.util.Map;

public interface WarehouseSelectionStrategy {


    Warehouse getWarehouse(Map<String,Integer> itemMap, String city);
}
