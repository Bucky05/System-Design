package algorithms;

public class EqualAmountDistributionAlgorithm implements AmountDistributionAlgorithm{



    @Override
    public double getAmountPayablePerPerson(int totalPeople, double amount) {
        return amount/(double)totalPeople;
    }
}
