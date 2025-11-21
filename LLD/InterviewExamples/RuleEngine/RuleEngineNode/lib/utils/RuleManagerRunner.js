
import RuleRegistry  from "../registry/RuleRegistry.js"
export default class RuleManagerRunner {

    constructor(ruleEngine) {
        this.ruleEngine = ruleEngine
    }

    run(expenses) {
        const expenseRuleRegistry = RuleRegistry.getExpenseRuleRegistry()
        const allExpenseRule = RuleRegistry.getAllExpenseRuleRegistry()
        const tripRulesRegistry = RuleRegistry.getAllTripRulesRegistry()

        const violations = this.ruleEngine.evaluate(tripRulesRegistry,expenses,expenseRuleRegistry,allExpenseRule)

        for(let violation of violations) {
            console.log(violation.getMessage())
        }
    }
}