package db;
import java.util.ArrayList;
import java.util.List;
public class InMemoryDatabase {
    List<String> users;
    public InMemoryDatabase seeder() {
        users = new ArrayList<>();
        for(int i = 0 ; i < 1000 ; i++) {
            users.add("User " +i);
        }
        return this;
    }

    public List<String> getUsers() {
        return users;
    }
}
