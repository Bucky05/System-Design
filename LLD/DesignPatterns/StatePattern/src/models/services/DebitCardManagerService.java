package models.services;
import models.Card;

public class DebitCardManagerService implements CardManagerService {
    
    @Override
    public boolean validateCard(Card card, int pin) {
        //ideally make it connect to apis
        return card.getPin() == pin;
    }

    @Override
    public boolean validateWithdrawl(int transactionID, int amount) {
        return true;
    }

    @Override
    public boolean doTransaction(Card card, int amount, int transactionID) {
        return true;
    }
}
