package dto;
import enums.ATMStates;
public class UpdateStateDTO {

    private final String atmID;
    private final ATMStates state;

    
    public UpdateStateDTO(String atmID, ATMStates state) {
        this.atmID = atmID;
        this.state = state;
    }
    public String getATMID() {
        return atmID;
    }

    public ATMStates getState() {
        return state;
    }
    
}
