package factories;

import models.User;
public interface UserFactory {

    public User createUser(String userName, String userEmail);
}
