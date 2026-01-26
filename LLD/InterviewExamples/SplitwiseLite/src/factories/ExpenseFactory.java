package factories;

import enums.ExpenseType;
import models.Expense;
public interface ExpenseFactory {

    public Expense createExpense(double amountSpent, ExpenseType expenseType);
}
