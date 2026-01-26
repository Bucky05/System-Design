package factories;

import models.Expense;
import models.User;
import models.Ledger;

public class LedgerFactoryImpl implements LedgerFactory{

    public Ledger createLedger(Expense expense, double amount, User owedTo, User owedFrom) {
        return new Ledger(expense,amount,owedTo,owedFrom);
    }
}
