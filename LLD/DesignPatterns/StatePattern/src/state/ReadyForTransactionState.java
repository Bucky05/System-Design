package state;

import enums.ATMStates;
import models.Card;
import models.ATM;

import api.BackendAPI;
import api.NodeBackendAPI;
import dto.CreateTransactionDTO;

public class ReadyForTransactionState implements State{

    private final ATM atm;
    private final BackendAPI backendAPI;
    public ReadyForTransactionState(ATM atm) {
        this.atm = atm;
        backendAPI = new NodeBackendAPI();
    }

    @Override
    public int dispenseCash( int amount) {
        throw new IllegalStateException("Cannot dispense cash before reading the card details.");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card before initialization");
        
    }

    @Override
    public ATMStates getState() {
        // TODO Auto-generated method stub
        return ATMStates.READY_FOR_TRANSACTION;
    }

    @Override
    public int initTransaction(Card card) {
        CreateTransactionDTO createTransactionDTO = new CreateTransactionDTO(this.atm.getATMID());
        int transactionID = this.backendAPI.createTransaction(createTransactionDTO);
        if(transactionID == 0) {
            throw new RuntimeException("Transaction could not be created");
        }
        // Now that we have transaction id we should move to next state

        this.atm.changeState(new ReadingCardDetailsAndPinState(this.atm,card,transactionID));
        return transactionID;
    }

    @Override
    public boolean readCardDetailsAndPin( int pin) {
        throw new IllegalStateException("Cannot read card details before inserting the card");
    }

    @Override
    public boolean readCashWithdrawlDetails(  int amount) {
        throw new IllegalStateException("Cannot read cash withdraw details before reading card details.");
    }

    @Override
    public boolean cancelTransaction() {
        throw new IllegalStateException("Cannot cancel transaction before starting the transaction");
    }
    
    
    
}
