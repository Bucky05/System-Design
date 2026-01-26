package services;

import algorithms.AmountDistributionAlgorithm;
import algorithms.EqualAmountDistributionAlgorithm;
import enums.AmountDistributionAlgorithmType;
import enums.ExpenseType;
import factories.*;
import repositories.*;
import models.*;

import java.util.List;

public class ExpenseTrackerService {

    UserRepository userRepository;
    LedgerRepository ledgerRepository;
    ExpenseRepository expenseRepository;

    UserFactory userFactory;
    LedgerFactory ledgerFactory;
    ExpenseFactory expenseFactory;

    AmountDistributionAlgorithm amountDistributionAlgorithm;

    public ExpenseTrackerService() {
        this.userRepository = new UserRepositoryImpl();
        this.expenseRepository = new ExpenseRepositoryImpl();
        this.ledgerRepository = new LedgerRepositoryImpl();

        this.userFactory = new UserFactoryImpl();
        this.ledgerFactory = new LedgerFactoryImpl();
        this.expenseFactory = new ExpenseFactoryImpl();
        amountDistributionAlgorithm = new AmountDistributionAlgorithmFactoryImpl().createAmountDistributionAlgorithm(AmountDistributionAlgorithmType.EQUAL_DISTRIBUTION);


    }

    public User addUser(String userName, String userEmail) {

        try {
            User user = userFactory.createUser(userName, userEmail);
            userRepository.addUser(user);
            System.out.println(user.getUserName() + " added successfully");
            return user;
        } catch (Exception e) {
            System.out.println("Failed to add "+userName);
            return null;
        }
    }

    public void addExpense(double amount, List<User> owedFrom, User owedTo, ExpenseType expenseType) {
        Expense expense = expenseFactory.createExpense(amount,expenseType);

        createLedger(expense,owedFrom, owedTo);
        System.out.println("Expense added successfully");
    }

    private void createLedger(Expense expense, List<User> users, User paidBy) {

        double amountPayableByEach = amountDistributionAlgorithm.getAmountPayablePerPerson(users.size()+1,expense.getAmountSpent());

        for(User user : users) {
            Ledger currLedger = ledgerFactory.createLedger(expense,amountPayableByEach,paidBy,user);
            ledgerRepository.addLedger(currLedger);
        }
    }

    public void balanceOfEachUser() {
        List<User> users = userRepository.getAllUsers();

        for(User user : users) {
            balanceOfUser(user);
        }
    }
    public void balanceOfUser(User user) {

        double receivableAmount = 0.0;
        double payableAmount = 0.0;

        List<Ledger> ledgerList = ledgerRepository.getLedgersByUser(user);

        for(Ledger ledger : ledgerList) {
            double amount = ledger.getAmount();
            if(ledger.getOwedTo() == user) {
                receivableAmount += amount;
            } else {
                payableAmount += amount;
            }
        }

        System.out.println("User: "+user.getUserName()+" "+" Amount receivable: "+ receivableAmount+" "+"Payable Amount: "+payableAmount+" "+" Final Balance: "+(receivableAmount-payableAmount));
    }
}
