package models;

import enums.ExpenseType;

import java.util.UUID;

public class Expense {

    String expenseID ;
    double amountSpent;
    ExpenseType expenseType;

    public Expense(double amountSpent, ExpenseType expenseType) {
        this.expenseID = UUID.randomUUID().toString();
        this.amountSpent = amountSpent;
        this.expenseType = expenseType;
    }

    public String getExpenseID() {
        return this.expenseID;
    }

    public ExpenseType getExpenseType() {
        return this.expenseType;
    }

    public double getAmountSpent() {
        return this.amountSpent;
    }

}
