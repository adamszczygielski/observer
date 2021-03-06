package observer.application.task;

import lombok.RequiredArgsConstructor;
import observer.application.notification.NotificationService;
import observer.application.service.SearchService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Scheduler {

    private final SearchService searchService;
    private final NotificationService notificationService;

    @Scheduled(fixedDelayString = "#{@configProperties.getScheduledSearchDelay()}")
    private void updateSearches() {
        searchService.execute();
    }

    @Scheduled(fixedDelayString = "#{@configProperties.getScheduledNotificationDelay()}")
    private void sendNotification() {
        notificationService.execute();
    }

}
