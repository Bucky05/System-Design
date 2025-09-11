package SOLID.Example4.BetterCode;

public class WhatsAppNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("WhatsApp notification: "+ message);
    }
}