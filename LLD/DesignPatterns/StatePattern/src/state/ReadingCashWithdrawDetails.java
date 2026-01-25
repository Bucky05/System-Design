package state;

import enums.ATMStates;
import factories.CardManagerFactory;
import models.Card;
import models.services.CardManagerService;
import models.ATM;

public class ReadingCashWithdrawDetails implements State{

    
    private final ATM atm;

    public ReadingCashWithdrawDetails(ATM atm) {
        this.atm = atm;
    }
    @Override
    public int dispenseCash(Card card, int amount,int transactionId) {
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
    public int initTransaction() {
         throw new IllegalStateException("Cannot init transaction while reading cash withdraw details");   
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, int pin) {
         throw new IllegalStateException("Cannot read card details and pin while reading cash withdraw details");   
    }

    @Override
    public boolean readCashWithdrawlDetails(Card card, int transactionId, int amount) {
        CardManagerService cardManagerService = CardManagerFactory.getCardManagerService(card.getCardType());
        boolean isWithdrawValid = cardManagerService.validateWithdrawl(transactionId, amount);
        if(isWithdrawValid) {
            atm.changeState(new DispensingCashState(atm));
        } else {
            atm.changeState(new EjectingCardState(atm));
        }
        return isWithdrawValid;
    }
    @Override
    public boolean cancelTransaction(Card card) {
        try {
            atm.changeState(new EjectingCardState(atm));
            return true;
        } catch(Exception e) {
            throw new IllegalStateException("Cannot cancel transaction while reading cash withdraw details"); // just to mimic real cases
        }
    }
    
}
