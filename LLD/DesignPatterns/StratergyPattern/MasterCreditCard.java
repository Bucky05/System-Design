package DesignPattern.StrategyPattern;

public class MasterCreditCard extends CreditCard implements UPICompatibleCreditCard {
    @Override
    // functions doesnt support doRefund

    
    private RefundStrategy refundStratergy;

    public MasterCreditCard() {
        // this is strategy pattern implementation
        this.refundStratergy = new RefundAlgo2();
    }
}