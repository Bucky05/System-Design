package models.services;

import models.Card;
public class CreditCardManagerService implements CardManagerService {

    @Override
    public boolean validateCard(Card card, int pin) {
        // implement
        return true;
    }

    @Override
    public boolean validateWithdrawl(int transactionID, int amount) {
        return true;
    }

    @Override
    public boolean doTransaction(Card card, int amount, int transactionID) {
        // maybe utilize methods of card interface 
        return true;
    }
    
}
