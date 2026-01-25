package dto;

import models.ATM;
public class GetATMAmountRequestDTO {
    
    private final ATM atm;

    public GetATMAmountRequestDTO(ATM atm) {
        this.atm = atm;
    }

    public String getATMID() {
        return this.atm.getATMID();
    }


}
