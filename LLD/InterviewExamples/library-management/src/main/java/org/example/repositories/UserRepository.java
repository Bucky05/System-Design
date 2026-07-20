package org.example.repositories;

import org.example.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
    }
}
