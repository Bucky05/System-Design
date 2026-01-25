package state;

import enums.ATMStates;
import factories.CardManagerFactory;
import models.Card;
import models.services.CardManagerService;
import models.ATM;

public class ReadingCashWithdrawDetails implements State{

    
    private final ATM atm;
    private final Card card;
    private final int transactionID;
    public ReadingCashWithdrawDetails(ATM atm, Card card, int transactionID) {

        this.atm = atm;
        this.card = card;
        this.transactionID = transactionID;
    }
    @Override
    public int dispenseCash( int amount) {
        throw new IllegalStateException("Cannot dispense cash while reading cash withdraw details");   
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card while reading cash withdraw details");        
    }

    @Override
    public ATMStates getState() {
        return ATMStates.READING_CASH_WITHDRAW_DETAILS;
    }

    @Override
    public int initTransaction(Card card) {
         throw new IllegalStateException("Cannot init transaction while reading cash withdraw details");   
    }

    @Override
    public boolean readCardDetailsAndPin( int pin) {
         throw new IllegalStateException("Cannot read card details and pin while reading cash withdraw details");   
    }

    @Override
    public boolean readCashWithdrawlDetails( int amount) {
        CardManagerService cardManagerService = CardManagerFactory.getCardManagerService(card.getCardType());
        boolean isWithdrawValid = cardManagerService.validateWithdrawl(transactionID, amount);
        if(isWithdrawValid) {
            atm.changeState(new DispensingCashState(atm,card,transactionID));
        } else {
            atm.changeState(new EjectingCardState(atm,card,transactionID));
        }
        return isWithdrawValid;
    }
    @Override
    public boolean cancelTransaction() {
        try {
            atm.changeState(new EjectingCardState(atm,card,transactionID));
            return true;
        } catch(Exception e) {
            throw new IllegalStateException("Cannot cancel transaction while reading cash withdraw details"); // just to mimic real cases
        }
    }
    
}
