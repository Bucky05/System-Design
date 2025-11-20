package SOLID.Example4.BetterCode;

public abstract class CreditCard {
    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private int cvv;

    //Getters and Setters

    public abstract void swipeAndPay();
    //public abstract void doRefund(); removing as not used by all
    public abstract void onlinePayment();
    public abstract void tapAndPay();
    //public abstract void upiPayment(); removing as not used by all
}
