package models;
import java.util.UUID;
public class User {

    private String userID;
    private String userName;
    private String userEmail;

    public User(String userName, String userEmail){
        this.userEmail = userEmail;
        this.userName = userName;
        this.userID = UUID.randomUUID().toString();
    }

    public String getUserID() {
        return this.userID;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserEmail() {
        return this.userEmail;
    }
}
