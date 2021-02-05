package observer.application.task;

import lombok.AllArgsConstructor;
import observer.application.notification.NotificationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NotificationTask {

    private final NotificationService notificationService;

    @Scheduled(fixedDelayString = "${observer.scheduled.delay}")
    public void sendNotifications() {
        notificationService.execute();
    }
}
