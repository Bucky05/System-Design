import Rule  from '../Rule.js'
import Violation  from '../Violation.js'
export default class DisallowRule extends Rule {

    check = (expense) => {
        return new Violation(`Expense type ${expense.expenseType} is not allowed`)
    }
} 