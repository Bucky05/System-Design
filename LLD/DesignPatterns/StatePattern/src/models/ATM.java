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


}
