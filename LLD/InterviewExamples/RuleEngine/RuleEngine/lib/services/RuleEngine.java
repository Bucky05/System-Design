package services;

import java.util.List;
import java.util.Map;

import models.Expense;
import models.ExpenseType;
import services.rules.ExpenseRule;
import services.rules.TripRule;
import services.rules.Violation;

// not making it a class becase caller will directly use ruleEngine which will make two concret class dependent
public interface RuleEngine {
    
    List<Violation> evaluate(
        List<TripRule> rule,
        List<Expense> expenses,
        Map<ExpenseType, List<ExpenseRule>> expenseRuleRegistry,
        List<ExpenseRule> allExpenseRuleRegistry
    );
}
