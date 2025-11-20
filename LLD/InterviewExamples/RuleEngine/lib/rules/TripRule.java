package lib.rules;

import java.util.List;
import java.util.Optional;

import lib.models.Expense;

public interface TripRule {
    Optional<List<Violation>> check(List<Expense> expenses);
}
