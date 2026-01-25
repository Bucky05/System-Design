package dto;

public class CreateTransactionDTO {
    
    private final String atmID;

    public CreateTransactionDTO(String atmID) {
        this.atmID = atmID;
    }

    public String getATMID(){
        return this.atmID;
    }
}
