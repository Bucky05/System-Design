import models.ATM;
import state.ReadyForTransactionState;
import state.State;
public class App {
    public static void main(String[] args) throws Exception {
        ATM atm = new ATM("123");
        State state = new ReadyForTransactionState(atm);

        //state.ejectCard();
        state.initTransaction();

    }
}
