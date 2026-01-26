package repositories;

import models.Expense;

import java.util.List;

public interface ExpenseRepository {

    public List<Expense> findAll();

    public List<Expense> findByID(String expenseID);

    public boolean addExpense(Expense expense);


}
