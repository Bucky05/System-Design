package api;

import dto.*;

public interface BackendAPI {
    
    public int createTransaction(CreateTransactionDTO createTransactionDTO);

    public boolean updateState(UpdateStateDTO updateStateDTO);

    public int getATMAMount(GetATMAmountRequestDTO getATMAmountRequestDTO);
}
