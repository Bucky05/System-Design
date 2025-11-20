package services.rules.impl;

import java.util.Optional;

import models.Expense;
import services.rules.ExpenseRule;
import services.rules.Violation;
public class MaximumAmountRule implements ExpenseRule{
    
    private final double maxAmount;

    public MaximumAmountRule(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public Optional<Violation> check(Expense e) {
        if(e.getAmountUsd() > maxAmount) {
            return Optional.of(Violation.of("Expense amount is greater than the max amount"));
        }

        return Optional.empty();
    }
}
