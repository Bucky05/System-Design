package models.services;

import api.NodeBackendAPI;
import dto.GetATMAmountRequestDTO;
import models.ATM;
import state.ReadyForTransactionState;
import api.BackendAPI;
public class CashDispenseServiceImpl implements CashDispenseService{
    
    private final BackendAPI backendAPI;
    
    public CashDispenseServiceImpl() {
        this.backendAPI = new NodeBackendAPI();
    }

   

    @Override
    public void dispenseCash(ATM atm, int transactionID, int amount) {
        int atmAmount = this.backendAPI.getATMAMount(new GetATMAmountRequestDTO(atm));

        if(atmAmount < amount) {
            throw new RuntimeException("ATM does not have enough cash to dispense");
        }

        System.out.println("Collect your cash of: "+amount);
        atm.changeState(new ReadyForTransactionState(atm));
    }
}
