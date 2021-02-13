package observer.application.task;

import lombok.RequiredArgsConstructor;
import observer.application.notification.NotificationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationTask {

    private final NotificationService notificationService;

    @Scheduled(fixedDelayString = "${observer.scheduled.delay}")
    public void sendNotifications() {
        notificationService.execute();
    }
}
