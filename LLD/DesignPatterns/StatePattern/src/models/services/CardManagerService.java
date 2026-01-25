package models.services;

import models.ATM;
import models.Card;
public interface CardManagerService {
    
    boolean validateCard(Card card, int pin);

    boolean validateWithdrawl(int transactionID, int amount);

    boolean doTransaction(Card card, int amount, int transactionID);
}
