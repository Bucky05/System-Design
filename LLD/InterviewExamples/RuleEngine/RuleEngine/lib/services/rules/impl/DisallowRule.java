package services.rules.impl;

import java.util.Optional;

import models.Expense;
import services.rules.ExpenseRule;
import services.rules.Violation;

public class DisallowRule implements ExpenseRule{
    @Override
    public Optional<Violation> check(Expense e) {
        return Optional.of(Violation.of("Expense type "+ e.getExpenseType() + " is not allowed"));
    }
}
