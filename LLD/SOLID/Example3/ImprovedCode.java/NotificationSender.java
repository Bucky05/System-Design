package SOLID.Example4.BetterCode;

import java.util.List;
public class NotificationSender {
    public void sendNotification(List<Notification> notifications, String message) {
        for(Notification notification : notifications) {
            notification.sendNotification(message)
        }
    }
}