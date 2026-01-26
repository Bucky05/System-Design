package repositories;

import models.User;

import java.util.List;

public interface UserRepository {

    public User getUserByID(String userID);
    public List<User> getAllUsers();
    public boolean addUser(User user);
}
