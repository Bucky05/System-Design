package factories;


import enums.ExpenseType;
import models.Expense;

public class ExpenseFactoryImpl implements ExpenseFactory {

    @Override
    public Expense createExpense(double amountSpent, ExpenseType expenseType) {
        return new Expense(amountSpent,expenseType);
    }
}
