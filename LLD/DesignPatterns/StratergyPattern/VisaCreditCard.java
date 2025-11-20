package DesignPattern.StrategyPattern;

public class VisaCreditCard extends CreditCard implements UPICompatibleCreditCard, RefundCompatibleCreditCard {
    @Override
    // functions


    private RefundStrategy refundStratergy;

    public VisaCreditCard() {
        // this is strategy pattern implementation
        this.refundStratergy = new RefundAlgo1();
    }
}