import DisallowRule  from '../services/rules/impl/DisallowRule.js'
import MaximumAmountRule  from '../services/rules/impl/MaximumAmountRule.js'
import ExpenseType  from '../models/ExpenseType.js'
export default class RuleRegistry {
    static getExpenseRuleRegistry =() =>{
        const RESTAURANT = ExpenseType["RESTAURANT"]
        const AIRFARE = ExpenseType["AIRFARE"]
        return {
            RESTAURANT: [new DisallowRule(), new MaximumAmountRule(100)],
            AIRFARE: [new DisallowRule()]
        }
    }

    static getAllExpenseRuleRegistry = () => {
        return [
            new MaximumAmountRule(200)
        ]
    }

    static getAllTripRulesRegistry = () => {
        return [
            new MaximumAmountRule(1000)
        ]
    }
}