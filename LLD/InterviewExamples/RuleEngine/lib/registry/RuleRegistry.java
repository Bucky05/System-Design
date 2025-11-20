package lib.registry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import lib.rules.ExpenseRule;
import lib.models.ExpenseType;
import lib.rules.impl.DisallowRule;
import lib.rules.impl.MaximumAmountRule;

// registry is class where you store some mapping, like a json config
public class RuleRegistry {
    public static void getExpenseRulesRegistry() {
        Map<ExpenseType, List<ExpenseRule>> registry = new HashMap<>();
        // list.of create immutable list added in java 9, here directly creating
        registry.put(ExpenseType.RESTAURANT, Arrays.asList(
            new DisallowRule(),
            new MaximumAmountRule(75)
        ));

        registry.put(ExpenseType.AIRFARE,  Arrays.asList(
            new DisallowRule()
        ));
    }

    public static List<ExpenseRule> getAllExpenseRuleRegistry() {
        List<ExpenseRule> registry = new ArrayList<>();

        return Arrays.asList(
            new MaximumAmountRule(200)
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
