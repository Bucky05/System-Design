package PrototypePattern.NaiveSolution;

public class Email {
    String sender;
    String recepient;
    String body;

    public Email(String sender, String recepient, String body) {
        this.sender = sender;
        this.recepient = recepient;
        this.body = body;
    }

    // copy constructor

    public Email(Email email) {
        this.sender = email.getSender();
        this.recepient = email.getRecepient();
        this.body = email.getBody();

    }
    public void setBody(String body) {
        this.body  = body;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setRecepient(String recepient) {
        this.recepient = recepient;
    }

    public String getBody() {
        return this.body;
    }

    public String getSender() {
        return this.sender;
    }

    public String getRecepient() {
        return this.recepient;
    }

    public void display() {
        System.out.println(this.sender+ " " + this.recepient+" \n"+this.body)
    }
}
