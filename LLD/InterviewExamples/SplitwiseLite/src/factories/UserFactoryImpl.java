package factories;

import models.User;

public class UserFactoryImpl implements UserFactory {

    @Override
    public User createUser(String userName, String userEmail) {
        return new User(userName,userEmail);
    }
}
