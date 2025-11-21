import Rule  from '../Rule.js'
import Violation from '../Violation.js'
export default class MaximumAmountRule extends Rule{
    constructor(maxAmount) {
        super()
        this.maxAmount = maxAmount
    }

    check(expense) {
        if(Array.isArray(expense)) {
            let currAmount = 0
            for(let e of expense) {
                currAmount += e.getAmountUsd
                if(currAmount > this.maxAmount) {
                    return new Violation("Expense amount exceeds trip max amount limit of "+this.maxAmount)
                }
            }
        } else {
            if(expense.getAmountUsd() > this.maxAmount) {
                return new Violation("Expense amount exceeds max amount limit of "+this.maxAmount)
            }
        }

        return null
    }
}