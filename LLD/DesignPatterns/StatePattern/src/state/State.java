package state;

import models.Card;
import enums.ATMStates;
public interface State {
    
    int initTransaction(Card card);

    boolean readCardDetailsAndPin( int pin); //read and return isValid

    int dispenseCash( int amount);

    void ejectCard();

    boolean readCashWithdrawlDetails(  int amount);

    boolean cancelTransaction();

    ATMStates getState();

}
