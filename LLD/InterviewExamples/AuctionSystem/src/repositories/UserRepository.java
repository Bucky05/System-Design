package repositories;

import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return this.userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User getUserById(String id) {
        Optional<User> u =  userList.stream().filter(user -> user.getId().equals(id)).findFirst();
        if(u.isPresent()) {
            return u.get();
        } else {
            return null;
        }
    }
}
