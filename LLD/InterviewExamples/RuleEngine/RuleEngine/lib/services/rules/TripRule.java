package services.rules;

import java.util.List;
import java.util.Optional;

import models.Expense;

public interface TripRule {
    Optional<Violation> check(List<Expense> expenses);
}
