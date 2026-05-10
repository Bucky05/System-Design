import models.User;
import services.RouteManagerService;
import services.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        RouteManagerService routeManagerService = new RouteManagerService();

        String user1 = routeManagerService.createUser("Ram");
        String user2 = routeManagerService.createUser("Lakshman");

        routeManagerService.getUserProfile(user1);
        routeManagerService.getUserProfile(user2);
        routeManagerService.getUserProfile(user1);
        routeManagerService.getUserProfile(user2);
        routeManagerService.getUserProfile(user1);
        routeManagerService.getUserProfile(user2);


        routeManagerService.getUserProfile(user1);
        routeManagerService.getUserProfile(user2);
        routeManagerService.getUserProfile(user1);
        routeManagerService.getUserProfile(user2);
        Thread.sleep(30001);
        routeManagerService.getUserProfile(user1);
        routeManagerService.getUserProfile(user2);


    }
}