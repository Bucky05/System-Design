package state;

import enums.ATMStates;
import models.Card;
import models.ATM;
public class EjectingCardState implements State{

    private final ATM atm;

    public EjectingCardState(ATM atm) {
        this.atm = atm;
    }
    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot init transaction while ejecting card");
        
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, int pin) {
         throw new IllegalStateException("Cannot read card details and pin while ejecting card");
    }

    @Override
    public int dispenseCash(Card card, int amount, int transactionId) {
         throw new IllegalStateException("Cannot dispense cash while ejecting card");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected, please collect");
        this.atm.changeState(new ReadyForTransactionState(atm));
    }

    @Override
    public boolean readCashWithdrawlDetails(Card card, int transactionId, int amount) {
         throw new IllegalStateException("Cannot read cash withdrwal details while ejecting card");
    }

    @Override
    public boolean cancelTransaction(Card card) {
         throw new IllegalStateException("Cannot cancel transaction while ejecting card");
    }

    @Override
    public ATMStates getState() {
        return ATMStates.EJECTING_CARD;
    }
    
}
