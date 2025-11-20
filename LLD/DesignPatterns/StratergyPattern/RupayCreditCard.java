package DesignPattern.StrategyPattern;


public class RupayCreditCard extends CreditCard implements RefundCompatibleCreditCard {
    @Override
    // functions


    private RefundStrategy refundStratergy;

    public RupayCreditCard() {
        // this is strategy pattern implementation
        this.refundStratergy = new RefundAlgo1();
    }
}