package SOLID.Example4.BetterCode;

public class MasterCreditCard extends CreditCard implements UPICompatibleCreditCard {
    @Override
    // functions doesnt support doRefund

    private RefundStratergy refundStratergy;

    public MasterCreditCard() {
        this.refundStratergy = new RefundAlgo1()
    }
     @override
    public void doRefund() {
        this.refundStratergy.doRefund()
    }
}