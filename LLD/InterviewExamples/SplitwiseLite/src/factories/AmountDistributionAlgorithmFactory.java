package factories;

import algorithms.AmountDistributionAlgorithm;
import enums.AmountDistributionAlgorithmType;

public interface AmountDistributionAlgorithmFactory {

    public AmountDistributionAlgorithm createAmountDistributionAlgorithm(AmountDistributionAlgorithmType type);
}
