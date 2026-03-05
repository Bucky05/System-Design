package factories;

import enums.VictoryStrategyEnum;
import strategies.StandardVictoryStrategy;
import strategies.VictoryStrategy;

public class VictoryStrategyFactory {

    public static VictoryStrategy create(VictoryStrategyEnum strategy) {
        if(strategy == VictoryStrategyEnum.STANDARD) {
            return new StandardVictoryStrategy();
        } else {
            throw new IllegalArgumentException("Provided strategy doesn't exists");
        }
    }
}
