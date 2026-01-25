package state;

import enums.ATMStates;
import factories.CardManagerFactory;
import models.Card;
import models.services.CardManagerService;
import models.ATM;
public class ReadingCardDetailsAndPinState implements State{

    
    
    private final ATM atm;
    private final Card card;
    private final int transactionID;
    public ReadingCardDetailsAndPinState(ATM atm, Card card, int transactionID) {

        this.atm = atm;
        this.card = card;
        this.transactionID = transactionID;
    }
    @Override
    public int dispenseCash(int amount) {
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
    public boolean cancelTransaction() {
        try {
            atm.changeState(new EjectingCardState(atm,card,transactionID));
            return true;
        } catch(Exception e) {
            throw new IllegalStateException("Cannot cancel transaction while reading card details and pin"); // just to mimic real cases
        }
    }
    @Override
    public int initTransaction(Card card) {
        throw new IllegalStateException("Cannot init transation while reading card details and pin");
    }

    @Override
    public boolean readCardDetailsAndPin(int pin) {
        CardManagerService cardManagerService = CardManagerFactory.getCardManagerService(card.getCardType());
        boolean isCardValid = cardManagerService.validateCard(card, pin);
        if(isCardValid) {
            atm.changeState(new ReadingCashWithdrawDetails(this.atm,card,transactionID));
        } else {
            atm.changeState(new EjectingCardState(atm,card,transactionID));
        }

        return isCardValid;
    }

    @Override
    public boolean readCashWithdrawlDetails(  int amount) {
        throw new IllegalStateException("Cannot read cash withdraw details while reading card details and pin");
    } 
    
    
}
