package services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import models.Expense;
import models.ExpenseType;
import services.RuleEngine;
import services.rules.ExpenseRule;
import services.rules.TripRule;
import services.rules.Violation;
public class SimpleRuleEngine implements RuleEngine{
    
    @Override
    public List<Violation> evaluate(   
        List<TripRule> tripRulesRegistry,
        List<Expense> expenses,
        Map<ExpenseType, List<ExpenseRule>> expenseRuleRegistry,
        List<ExpenseRule> allExpenseRuleRegistry
    ) {
        List<Violation> violationsResult = new ArrayList<>();

        // 1. Check all expenses against all expense rules

        for(Expense expense: expenses) {
            List<ExpenseRule> rules = expenseRuleRegistry.getOrDefault(expense.getExpenseType(),new ArrayList<ExpenseRule>());

           
            checkExpenseAgainstRules(expense, rules, violationsResult);
            checkExpenseAgainstRules(expense, allExpenseRuleRegistry, violationsResult);
        }
        
        // 2. Check all expense against all trip rules

        for(TripRule rule: tripRulesRegistry) {
            Optional<Violation> violation = rule.check(expenses);
            if(violation.isPresent()) {
                violationsResult.add(violation.get());
            }
        }

        return violationsResult;
    }

    private void checkExpenseAgainstRules(Expense expense, List<ExpenseRule> rules, List<Violation> violationsResult) {
         for(ExpenseRule rule : rules) {
                Optional<Violation> violation = rule.check(expense);
                if(violation.isPresent()) {
                    violationsResult.add(violation.get());
                }
            }
    }
}
