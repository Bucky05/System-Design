package state;

import enums.ATMStates;
import factories.CardManagerFactory;
import models.Card;
import models.services.CardManagerService;
import models.ATM;
public class ReadingCardDetailsAndPinState implements State{

    
    
    private final ATM atm;

    public ReadingCardDetailsAndPinState(ATM atm) {
        this.atm = atm;
    }
    @Override
    public int dispenseCash(Card card,int amount,int transactionId) {
        throw new IllegalStateException("Cannot dispense cash while reading card details and pin");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card while reading card details and pin");
        
    }

    @Override
    public ATMStates getState() {
        return ATMStates.READING_CARD_DETAILS_AND_PIN;
    }

    @Override
    public boolean cancelTransaction(Card card) {
        try {
            atm.changeState(new EjectingCardState(atm));
            return true;
        } catch(Exception e) {
            throw new IllegalStateException("Cannot cancel transaction while reading card details and pin"); // just to mimic real cases
        }
    }
    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot init transation while reading card details and pin");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card,int pin) {
        CardManagerService cardManagerService = CardManagerFactory.getCardManagerService(card.getCardType());
        boolean isCardValid = cardManagerService.validateCard(card, pin);
        if(isCardValid) {
            atm.changeState(new ReadingCashWithdrawDetails(this.atm));
        } else {
            atm.changeState(new EjectingCardState(atm));
        }

        return isCardValid;
    }

    @Override
    public boolean readCashWithdrawlDetails(Card card, int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdraw details while reading card details and pin");
    } 
    
    
}
