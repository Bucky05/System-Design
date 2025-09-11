package SOLID.Example4.BetterCode;

import java.util.List;
public class NotificationSender {
// here applying SRA by moving each notification to single class didn't solve much as 
// notificationType was kind of SRA only, issue is in notificationSender which will modify 
//with each new notification type introduction
    public void sendNotification(List<String> notificationTypes, String message) {
        for(String notificationType : notificationTypes) {
            switch(notificationType) {
                case "SMS":
                    SMSNotification notification = new SMSNotification();
                    notification.sendSMSNotification(message);
                    break;
                case "EMAIL":
                    EmailNotification notification = new EmailNotification()
                    notification.sendEmailNotification(message);
                    break;
                case "Push":
                    PushNotification notification = new PushNotification();
                    notification.sendPushNotification(message);
                case "WHATSAPP":
                    WhatsAppNotification notification = new WhatsAppNotification();
                    notification.sendWhatsAppNotification(message);
                    break;
            }
        }
    }
}