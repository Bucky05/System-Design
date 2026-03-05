package models;

import enums.UserTypeEnum;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private UserTypeEnum type;

    public User(String name, UserTypeEnum type) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserTypeEnum getType() {
        return type;
    }

    public boolean equals(User user) {
        return id.equals(user.getId());
    }
}
