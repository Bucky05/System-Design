package repositories;

import java.util.List;

import models.Expense;
import models.Ledger;
import models.User;

public interface LedgerRepository {

    public List<Ledger> getAllLedgers();
    public List<Ledger> getLedgersByUser(User user);
    public List<Ledger> getLedgersByExpense(Expense expense);
    public boolean addLedger(Ledger ledger) ;
}
