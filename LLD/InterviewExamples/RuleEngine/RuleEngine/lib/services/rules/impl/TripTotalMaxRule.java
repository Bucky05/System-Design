package services.rules.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import models.Expense;
import services.rules.TripRule;
import services.rules.Violation;
public class TripTotalMaxRule implements TripRule {
    private final double maxAmount;


    public TripTotalMaxRule(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public Optional<Violation> check(List<Expense> expenses) {
        int total = 0;
        for(Expense expense : expenses) {
            total += expense.getAmountUsd();
        }
        if(total > maxAmount) {
            return Optional.of(Violation.of("Total trip expense is greater than "+maxAmount ));
        }
        return Optional.empty();
    }
    
}
