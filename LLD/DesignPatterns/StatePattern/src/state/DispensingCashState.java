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
    private final Card card;
    private final int transactionId;
    public DispensingCashState(ATM atm,Card card,int transactionId) {
        this.atm = atm;
        this.cashDispenseService = new CashDispenseServiceImpl();
        this.card = card;
        this.transactionId = transactionId;
    }
    @Override
    public int initTransaction(Card card) {
        throw new IllegalStateException("Cannot init transaction while dispensing cash");
    }

    @Override
    public boolean readCardDetailsAndPin( int pin) {
        throw new IllegalStateException("Cannot read card details and pin while dispensing cash");
    }

    @Override
    public int dispenseCash(int amount) {
        CardManagerService cardManagerService = CardManagerFactory.getCardManagerService(card.getCardType());

        boolean isTransactionValid = cardManagerService.doTransaction(card,amount,transactionId);
        if(isTransactionValid) {
            this.cashDispenseService.dispenseCash(atm, transactionId, amount);
        }  else {
            System.out.println("Something went wrong");
            
        }
        atm.changeState(new EjectingCardState(atm,card,transactionId));
        return amount;
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card while dispensing cash");
    }

    @Override
    public boolean readCashWithdrawlDetails( int amount) {
        throw new IllegalStateException("Cannot read cash withdraw details  while dispensing cash");
    }

    @Override
    public boolean cancelTransaction() {
        throw new IllegalStateException("Cannot cancel transaction while dispensing cash");
    }

    @Override
    public ATMStates getState() {
        return ATMStates.DISPENSING_CASH;
    }
    
}
