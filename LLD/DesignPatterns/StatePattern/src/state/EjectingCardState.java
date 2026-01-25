package state;

import enums.ATMStates;
import models.Card;
import models.ATM;
public class EjectingCardState implements State{

    private final ATM atm;
    private final Card card;
    private final int transactionID;
    public EjectingCardState(ATM atm, Card card, int transactionID) {
        this.atm = atm;
        this.card = card;
        this.transactionID = transactionID;
    }
    @Override
    public int initTransaction(Card card) {
        throw new IllegalStateException("Cannot init transaction while ejecting card");
        
    }

    @Override
    public boolean readCardDetailsAndPin( int pin) {
         throw new IllegalStateException("Cannot read card details and pin while ejecting card");
    }

    @Override
    public int dispenseCash( int amount) {
         throw new IllegalStateException("Cannot dispense cash while ejecting card");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected, please collect");
        this.atm.changeState(new ReadyForTransactionState(atm));
    }

    @Override
    public boolean readCashWithdrawlDetails(  int amount) {
         throw new IllegalStateException("Cannot read cash withdrwal details while ejecting card");
    }

    @Override
    public boolean cancelTransaction() {
         throw new IllegalStateException("Cannot cancel transaction while ejecting card");
    }

    @Override
    public ATMStates getState() {
        return ATMStates.EJECTING_CARD;
    }
    
}
