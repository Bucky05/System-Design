import RuleEngine from "../RuleEngine.js";
export default class SimpleRuleEngine extends RuleEngine {

    evaluate(tripRulesRegistry,expenses,expenseRuleRegistry,allExpenseRuleRegistry) {
        const violationsResult = []

        for(let expense of expenses) {
            let rules = expenseRuleRegistry[expense.expenseType]

            if(Array.isArray(rules)) {
                this.checkExpenseAgainstRules(expense,rules,violationsResult)
            }
            this.checkExpenseAgainstRules(expense, allExpenseRuleRegistry,violationsResult)

        }

        for(let rule of tripRulesRegistry) {
            const violation = rule.check(expenses)
            if(violation) {
                violationsResult.add(violation)
            }
        }

        return violationsResult
    }

    checkExpenseAgainstRules(expense, rules, violationResult) {
        for(let rule of rules) {
            const violation = rule.check(expense)
            if(violation) {
                violationResult.push(violation)
            }
        }
    }
}