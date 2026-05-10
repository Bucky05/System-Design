package services;

import exceptions.RateLimitException;
import models.User;

public class RouteManagerService {

    CacheService cacheService;
    UserService userService;

    public RouteManagerService() {
        cacheService = new CacheService();
        userService = new UserService();
    }

    public void getUserProfile(String id) {
        int count = cacheService.getCount(id);
        if(count >= 5) {
            throw new RateLimitException("Limit reached for user: "+id);
        }

        cacheService.set(id);
        userService.printUserProfile(id);
    }

    public String createUser(String name) {
        return userService.createUser(name);
    }
}
