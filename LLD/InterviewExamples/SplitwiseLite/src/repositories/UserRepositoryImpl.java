package repositories;

import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{

    List<User> userList;

    public UserRepositoryImpl() {
        userList = new ArrayList<>();
    }

    @Override
    public User getUserByID(String userID) {
        for(User user : userList) {
            if(user.getUserID().equals(userID)) return user;
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userList;
    }

    @Override
    public boolean addUser(User user) {
        this.userList.add(user);
        return true;
    }
}
