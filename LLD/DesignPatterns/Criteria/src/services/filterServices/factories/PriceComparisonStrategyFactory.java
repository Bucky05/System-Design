package services.filterServices.factories;

import services.filterServices.strategies.GreaterThanStrategy;
import services.filterServices.strategies.LessThanStrategy;
import services.filterServices.strategies.PriceComparisonStrategy;
import services.filterServices.utils.Operators;

public class PriceComparisonStrategyFactory {

    public static PriceComparisonStrategy create(Operators comparisonType) {
        if(comparisonType.equals(Operators.GREATER_THAN)) {
            return new GreaterThanStrategy();
        } else if (comparisonType.equals(Operators.LESS_THAN)) {
            return new LessThanStrategy();
        }
        return null;
    }
}
