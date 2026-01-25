package state;

import enums.ATMStates;
import factories.CardManagerFactory;
import models.Card;
import models.services.CardManagerService;
import models.services.CashDispenseService;
import models.services.CashDispenseServiceImpl;
import models.ATM;

public class DispensingCashState implements State{

    private final ATM atm;
    private final CashDispenseService cashDispenseService;
    public DispensingCashState(ATM atm) {
        this.atm = atm;
        this.cashDispenseService = new CashDispenseServiceImpl();
    }
    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot init transaction while dispensing cash");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, int pin) {
        throw new IllegalStateException("Cannot read card details and pin while dispensing cash");
    }

    @Override
    public int dispenseCash(Card card,int amount, int transactionId) {
        CardManagerService cardManagerService = CardManagerFactory.getCardManagerService(card.getCardType());

        boolean isTransactionValid = cardManagerService.doTransaction(card,amount,transactionId);
        if(isTransactionValid) {
            this.cashDispenseService.dispenseCash(atm, transactionId, amount);
        }  else {
            System.out.println("Something went wrong");
            
        }
        atm.changeState(new EjectingCardState(atm));
        return amount;
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card while dispensing cash");
    }

    @Override
    public boolean readCashWithdrawlDetails(Card card, int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdraw details  while dispensing cash");
    }

    @Override
    public boolean cancelTransaction(Card card) {
        throw new IllegalStateException("Cannot cancel transaction while dispensing cash");
    }

    @Override
    public ATMStates getState() {
        return ATMStates.DISPENSING_CASH;
    }
    
}
