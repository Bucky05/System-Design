package repositories;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import models.Expense;
public class ExpenseRepositoryImpl implements ExpenseRepository{

    private final List<Expense> expenseList;

    public ExpenseRepositoryImpl() {
        this.expenseList = new ArrayList<>();
    }

    @Override
    public List<Expense> findAll() {
        return this.expenseList;
    }

    @Override
    public List<Expense> findByID(String expenseID) {
        return expenseList.stream().filter((expense) -> expense.getExpenseID().equals(expenseID)).collect(Collectors.toList());
    }

    @Override
    public boolean addExpense(Expense expense) {
        this.expenseList.add(expense);
        return true;
    }
}
