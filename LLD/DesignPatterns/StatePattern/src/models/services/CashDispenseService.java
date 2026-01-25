package models.services;

import models.ATM;
public interface CashDispenseService {
    
    void dispenseCash(ATM atm, int transactionID, int amount);
}
