package services;
import repositories.UserRepository;
import repositories.UserRepositoryImpl;

import java.util.List;

import db.InMemoryDatabase;
import iterators.Iterator;
import iterators.UserIterator;
public class UserService {

    private final UserRepository userRepository;
    private final Iterator<List<String>> userIterator;
    public UserService() {
        
        this.userRepository = new UserRepositoryImpl();
        this.userIterator = new UserIterator(10);
    }

    public void getUsersOnPlatform() {

        // Issues with userRopsitory.findUsers(limit,offset)
        // service layer has to keep track of currentOffset
        // whenever pagination is read, have to maintain offset
        // dont know when to stop, might have to write custom data

        //instead user iterator
        while(userIterator.hasNext()) {
            List<String> users = userIterator.next();
            System.out.println(users);
        }
    }
}
