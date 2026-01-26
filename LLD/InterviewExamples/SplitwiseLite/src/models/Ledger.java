package models;

public class Ledger {

    private Expense expense;
    private double amount;
    private User owedTo;
    private User owedFrom;

    public Ledger(Expense expense, double amount, User owedTo, User owedFrom) {
        this.expense = expense;
        this.amount = amount;
        this.owedFrom = owedFrom;
        this.owedTo = owedTo;
    }

    public Expense getExpense() {
        return this.expense;
    }

    public double getAmount() {
        return this.amount;
    }

    public User getOwedTo() {
        return this.owedTo;
    }

    public User getOwedFrom() {
        return this.owedFrom;
    }

    public boolean clearStatus() {
        if(this.amount == 0.0) {
            return false;
        } else {
            this.amount = 0.0;
            return true;
        }
    }
}
