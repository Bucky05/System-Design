package factories;

import models.parking.FindSlotStrategy;
import models.parking.LinearSearchFindingStrategy;

public class FindSlotStrategyFactory {

    public static FindSlotStrategy createLinearSearchFindingStrategy() {
        return new LinearSearchFindingStrategy();
    }
}
