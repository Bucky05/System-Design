package services;

import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    List<User> userList;

    public UserService() {
        this.userList = new ArrayList<>();
    }

    public String createUser(String name) {
        User user = new User(name);
        userList.add(user);
        System.out.println("User created");
        return user.getId();
    }

    public void printUserProfile(String id) {
        User user = userList.stream().filter((u)-> u.getId() == id).findFirst().get();
        System.out.println("Find user details below: ");
        System.out.println("ID: "+ user.getId()+". Name: "+user.getName());
    }
}
