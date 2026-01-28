import enums.ExpenseType;
import services.ExpenseTrackerService;

import models.User;
import java.util.List;
public class Main {

    public static void main(String[] args) {

        ExpenseTrackerService expenseTrackerService = new ExpenseTrackerService();

        User user1 = expenseTrackerService.addUser("Janak","abc@gmail.com");
        User user2 = expenseTrackerService.addUser("Ram","ram@gl.com");
        expenseTrackerService.addExpense(100,List.of(user1),user2, ExpenseType.FOOD);
        expenseTrackerService.balanceOfUser(user1);
        expenseTrackerService.balanceOfUser(user2);
        expenseTrackerService.balanceOfEachUser();

        User user3 = expenseTrackerService.addUser("Hanu","Abc@gml.com");

        expenseTrackerService.addExpense(900,List.of(user1,user2),user3,ExpenseType.HOUSE_EXPENSE);


        expenseTrackerService.balanceOfEachUser();




    }
}
