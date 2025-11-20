package lib.models;

//Ideally made using Builder pattern
public class Expense {
    private final String expenseId;
    private final String tripId;
    private final Double amountUsd;
    private final ExpenseType expenseType;

    public Expense(String expenseId, String tripId, Double amoundUsd, ExpenseType expenseType) {
        this.expenseId = expenseId;
        this.tripId = tripId;
        this.amountUsd = amoundUsd;
        this.expenseType = expenseType;
    }

    public String getExpenseId()  {
        return expenseId;
    }

    public String getTripId() {
        return tripId;
    }

    public Double getAmountUsd() {
        return amountUsd;
    }

    public ExpenseType gExpenseType(){
        return expenseType;
    }
}
