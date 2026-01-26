package factories;

import algorithms.AmountDistributionAlgorithm;
import algorithms.EqualAmountDistributionAlgorithm;
import enums.AmountDistributionAlgorithmType;

public class AmountDistributionAlgorithmFactoryImpl implements AmountDistributionAlgorithmFactory {

    @Override
    public AmountDistributionAlgorithm createAmountDistributionAlgorithm(AmountDistributionAlgorithmType type) {
        if(type == AmountDistributionAlgorithmType.EQUAL_DISTRIBUTION)
            return new EqualAmountDistributionAlgorithm();
        throw new IllegalArgumentException("No such algorithm exists");
    }
}
