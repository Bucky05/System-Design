import java.util.ArrayList;
import java.util.List;

import models.Expense;
import models.ExpenseType;
import utils.RuleManagerRunner;
import services.impl.SimpleRuleEngine;
public class App {
    public static void main(String[] args) {
        List<Expense> expenses = new ArrayList<>();

        expenses.add(new Expense("1", "1", 10.0, ExpenseType.RESTAURANT));
        expenses.add(new Expense("2", "1", 20.0, ExpenseType.RESTAURANT));
        expenses.add(new Expense("3", "1", 300.0, ExpenseType.RESTAURANT));
        
        RuleManagerRunner ruleManagerRunner = new RuleManagerRunner(new SimpleRuleEngine());
        ruleManagerRunner.run(expenses);
        
        
    }
}

// convert this to NodeJS