package lib.rules.impl;

import java.util.Optional;

import lib.models.Expense;
import lib.rules.ExpenseRule;
import lib.rules.Violation;

public class DisallowRule implements ExpenseRule{
    @Override
    public Optional<Violation> check(Expense e) {
        return Optional.of(Violation.of("Expense type "+ e.gExpenseType() + " is not allowed"));
    }
}
