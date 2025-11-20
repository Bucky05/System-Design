package registry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.ExpenseType;
import services.rules.ExpenseRule;
import services.rules.TripRule;
import services.rules.impl.DisallowRule;
import services.rules.impl.MaximumAmountRule;
import services.rules.impl.TripTotalMaxRule;

// registry is class where you store some mapping, like a json config
public class RuleRegistry {
    public static Map<ExpenseType, List<ExpenseRule>> getExpenseRulesRegistry() {
        Map<ExpenseType, List<ExpenseRule>> registry = new HashMap<>();
        // list.of create immutable list added in java 9, here directly creating
        
        registry.put(ExpenseType.RESTAURANT, Arrays.asList(
            new DisallowRule(),
            new MaximumAmountRule(75)
        ));

        registry.put(ExpenseType.AIRFARE,  Arrays.asList(
            new DisallowRule()
        ));

        return registry;
    }

    public static List<ExpenseRule> getAllExpenseRuleRegistry() {
        List<ExpenseRule> registry = new ArrayList<>();

        registry =  Arrays.asList(
            new MaximumAmountRule(200)
        );

        return registry;
    }

    public static List<TripRule> getAllTripRulesRegistry() {
        return Arrays.asList(
            new TripTotalMaxRule(1000)
        );
    }
}

/**
 * 
 * 
 * represent the above rules like a json config
 * 
 * {
 *  "expenseLevelRules": [
 *      {
 *          "expenseType":"RESTAURANT",
 *          "rules":[
 *          {
 *              "type":"DISALLOW",
 *              "maxAmount": 75
 *          }
 *          ]
 *      }
 * ],
 *  "allExpenseRule":[
 *  {
 *      "type":"MAX_AMOUNT",
 *      "maxAmount":200
 *  }
 *  ]
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 *  */ 
