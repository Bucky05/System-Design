package factories;

import services.NearestSlotAllocationStrategy;
import services.SlotAllocationStrategy;
import enums.Strategy;
public class StrategyFactory {

    public static SlotAllocationStrategy createStrategy(Strategy strategy) {
        SlotAllocationStrategy slotAllocationStrategy;
        if(strategy == Strategy.NEAREST_SLOT_ALLOCATION_STRATEGY) {
            slotAllocationStrategy = new NearestSlotAllocationStrategy();
        } else {
            throw new IllegalArgumentException("No such stratergy present");
        }
        return slotAllocationStrategy;
    }
}
