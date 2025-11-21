export default class Expense {
    constructor(expenseId, tripId, amountUsd, expenseType) {
        this.expenseId = expenseId;
        this.tripId = tripId
        this.amountUsd = amountUsd
        this.expenseType = expenseType
    }
    getExpenseId() { return this.expenseId; }
    getTripId() { return this.tripId; }
    getAmountUsd() { return this.amountUsd; }
    getExpenseType() { return this.expenseType; }
}





// module.exports = function Expense(expenseId, tripId, amountUsd, expenseType) {
//     this.expenseId = expenseId;
//     this.tripId = tripId
//     this.amountUsd = amountUsd
//     this.expenseType = expenseType

//     this.getExpenseId = () => this.expenseId
//     this.getTripId = () => this.tripId
//     this.getAmountUsd = () => this.amountUsd
//     this.getExpenseType = () => this.expenseType
//  }
// use when you have to support old javascript environmnt like pre ES6
// 
// this is a construct function meant to use with new, when used with new
// 1. new obj is created (let obj = {})
// 2. sets function's this to new obj  ( this.title = title => obj.title = title)
// 3. Links the new object to function's prototype , obj.__proto__ = Expense.prototype
//In short {tripId: "1", expenseType:"RESTAURANT",amount:23, expenseId : "1"} a new object is created with this
//
//
//
//
//