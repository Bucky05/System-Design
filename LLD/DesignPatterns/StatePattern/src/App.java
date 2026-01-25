import enums.CardType;
import models.ATM;
import models.VisaDebitCard;
import models.Card;
public class App {
    public static void main(String[] args) {
        ATM atm = new ATM("123");
        Card card = new VisaDebitCard(12345, 1234, "Anirudh", CardType.DEBIT,"SBI");

        atm.initTransaction(card);
        atm.readCardDetailsAndPin(1234);
        atm.readCashWithdrawlDetails(100);
        atm.dispenseCash(100);

    }
}
