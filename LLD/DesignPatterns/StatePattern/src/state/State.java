package state;

import models.Card;
import enums.ATMStates;
public interface State {
    
    int initTransaction();

    boolean readCardDetailsAndPin(Card card, int pin); //read and return isValid

    int dispenseCash(Card card, int amount, int transactionId);

    void ejectCard();

    boolean readCashWithdrawlDetails(Card card, int transactionId, int amount);

    boolean cancelTransaction(Card card);

    ATMStates getState();

}
