package repositories;
import java.util.List;

import db.InMemoryDatabase;

import java.util.ArrayList;
public class UserRepositoryImpl implements UserRepository{
    private InMemoryDatabase db;


    public UserRepositoryImpl() {
        this.db = new InMemoryDatabase().seeder();
    }
    @Override
    public List<String> findUsers(int limit, int offset) {
        // would have been mysql query here if not in memory
        List<String> users = db.getUsers();
        int start = (offset-1)*limit;

        if(start > users.size()) {
            return new ArrayList<String>();
        }
        int end = Math.min(start + limit,users.size());

        return users.subList(start,end);

    }
}
