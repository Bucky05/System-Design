package SOLID.Example2.ProblematicCode;

class UserManager {
    public void add(User user) {
        if(user.getAge() < 18) {
            throw new IllegalArgumentException("User is not adult");
        }
        System.out.println("User added");
    }

    public void delete(User user) {
        System.out.println("User deleted");
    }

    public void update(User user) {
        if(user.getAge() < 18) {
            throw new IllegalArgumentException("User is not adult");
        }

        System.out.println("User updated");
    }

    public void get(User user) {
        System.out.println("User returned");
    }

    //till now class was performing crud operation 

    //////// this functions is violating SRP as logging is different from crud and can be subjective
    public void logUserActivity(User user) {
        System.out.println("User activity logged")
    }
}