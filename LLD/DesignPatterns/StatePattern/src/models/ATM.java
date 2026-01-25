package models;

import api.BackendAPI;
import api.NodeBackendAPI;
import dto.UpdateStateDTO;
import state.ReadyForTransactionState;
import state.State;
public class ATM {
    
    private final String atmID;
    // in case the system restarts so state will be lost, to persist the state we also store in db, 
    private State state;
    private final BackendAPI backendAPI;
    private int transactionID;
    public ATM(String atmID) {
        this.atmID = atmID;
        this.backendAPI = new NodeBackendAPI();
        this.state = new ReadyForTransactionState(this);

    }   

    public String getATMID() {
        return this.atmID;
    }

    public void changeState(State newState) {
        this.state = newState;
        this.backendAPI.updateState(new UpdateStateDTO(this.atmID,this.state.getState()));
        //now call the server to persist the state on the server


    }

    public int initTransaction(Card card) {
        return state.initTransaction(card);
    }

    public boolean readCardDetailsAndPin(int pin) {
        return state.readCardDetailsAndPin(pin);
    }

    public int dispenseCash( int amount) {
        return state.dispenseCash(amount);
    }

    public void ejectCard() {
        this.state.ejectCard();
    }
    public boolean readCashWithdrawlDetails(int amount) {
        return this.state.readCashWithdrawlDetails(amount);

    }

    private boolean cancelTransaction() {
        return this.state.cancelTransaction();
    }


}
