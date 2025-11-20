package SOLID.Example4.StratergyPattern;

public class VisaCreditCard extends CreditCard implements UPICompatibleCreditCard, RefundCompatibleCreditCard {
    @Override
    // functions

     private RefundStratergy refundStratergy;

    public MasterCreditCard() {
        this.refundStratergy = new RefundAlgo2()
    }

    @override
    public void doRefund() {
        this.refundStratergy.doRefund()
    }
}
