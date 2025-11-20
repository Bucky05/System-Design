package lib.rules;

import java.util.Optional;

import lib.models.Expense;

public interface ExpenseRule {
    Optional<Violation> check(Expense e); // Optional because Violation not returned always, and checking if returned Violation is null -> not good practice
}
