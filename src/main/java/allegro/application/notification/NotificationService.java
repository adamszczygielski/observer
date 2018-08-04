package allegro.application.notification;

import allegro.application.common.Utils;
import allegro.application.entity.Item;
import allegro.application.entity.Search;

import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class NotificationService {

    public static void sendEmailNotification(Search search) {

        final String username = "allegro-app@neostrada.pl";
        final String password = "";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "poczta.neostrada.pl");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("allegro-app@neostrada.pl"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("aszczygielski@gmail.com"));
            message.setSubject("New items");
            message.setText(prepareMessage(search));

            Transport.send(message);

            System.out.println("Notification send on " + new Date());

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String prepareMessage(Search search) {
        StringBuilder text = new StringBuilder(search.getKeyword() + "\n" + "--------------------" + "\n");
        for(Item item : search.getItemList()) {
            text.append(item.getTitle()).append(" (").append(Utils.itemIdToUrl(item.getItemId())).append(")\n");
        }

        return text.toString();
    }
}
