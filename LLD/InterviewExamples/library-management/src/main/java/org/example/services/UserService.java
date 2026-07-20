package org.example.services;

import org.example.models.User;
import org.example.repositories.UserRepository;

public class UserService {

    public UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(String name) {
        User user = new User(userRepo.users.size(),name);
        this.userRepo.users.add(user);
        return user;
    }
}
