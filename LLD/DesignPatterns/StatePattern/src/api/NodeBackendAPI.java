package api;

import api.BackendAPI;
import dto.CreateTransactionDTO;
import dto.GetATMAmountRequestDTO;
import dto.UpdateStateDTO;
public class NodeBackendAPI implements BackendAPI{
    //will connect with backend and return response

    @Override
    public int createTransaction(CreateTransactionDTO createTransactionDTO) {

        // if(createTransactionDTO.getATMID() == null || createTransactionDTO.getATMID().isEmpty()) {
        //     throw new IllegalArgumentException("ATM ID cannot be empty");
        // }
        
         int transactionID = (int)(Math.random()*1000);
        return transactionID;
    }

    @Override
    public boolean updateState(UpdateStateDTO updateStateDTO) {
        /// Assume there is updateState API
        /// 
        return true;
    }

    @Override
    public int getATMAMount(GetATMAmountRequestDTO getATMAmountRequestDTO) {
        return 1000;
    }
}
