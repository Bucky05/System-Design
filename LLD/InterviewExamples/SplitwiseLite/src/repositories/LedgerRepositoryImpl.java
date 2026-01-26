package repositories;

import models.Ledger;
import models.Expense;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import models.User;
public class LedgerRepositoryImpl implements LedgerRepository {

    private final List<Ledger> ledgerList;

    public LedgerRepositoryImpl() {
        ledgerList = new ArrayList<>();
    }

    @Override
    public boolean addLedger(Ledger ledger) {
        this.ledgerList.add(ledger);
        return true;
    }

    @Override
    public List<Ledger> getAllLedgers() {
       return this.ledgerList;
    }

    @Override
    public List<Ledger> getLedgersByUser(User user) {
        return this.ledgerList.stream()
                .filter(ledger -> ledger.getOwedTo() == user || ledger.getOwedFrom() == user)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ledger> getLedgersByExpense(Expense expense) {
        return this.ledgerList.stream()
                .filter(ledger -> ledger.getExpense() == expense)
                .collect(Collectors.toList());
    }
}
