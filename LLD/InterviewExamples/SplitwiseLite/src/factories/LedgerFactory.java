package factories;

import models.Expense;
import models.User;
import models.Ledger;
public interface LedgerFactory {

    public Ledger createLedger(Expense expense, double amount, User owedTo, User owedFrom);
}
