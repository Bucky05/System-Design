package utils;

import registry.RuleRegistry;
import services.RuleEngine;
import services.rules.ExpenseRule;
import services.rules.TripRule;
import services.rules.Violation;

import java.util.List;
import java.util.Map;

import models.Expense;
import models.ExpenseType;
//controller
public class RuleManagerRunner {
    
    private final RuleEngine ruleEngine;

    public RuleManagerRunner(RuleEngine ruleEngine) {
        this.ruleEngine = ruleEngine;
    }

    public void run(List<Expense> expenses) {
        Map<ExpenseType, List<ExpenseRule>> expenseRuleRegistry = RuleRegistry.getExpenseRulesRegistry();
        List<ExpenseRule> allExpenseRule = RuleRegistry.getAllExpenseRuleRegistry();
        List<TripRule> tripRulesRegistry = RuleRegistry.getAllTripRulesRegistry();

        List<Violation> violations = ruleEngine.evaluate(tripRulesRegistry, expenses, expenseRuleRegistry, allExpenseRule);
        for(Violation violation : violations) {
            System.out.println(violation.getMessage());
        }
    }   
}
