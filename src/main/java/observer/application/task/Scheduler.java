package observer.application.task;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Scheduler <T extends ScheduledTask> {

    private final T searchService;
    private final T notificationService;

    @Scheduled(fixedDelayString = "#{@configProperties.getScheduledSearchDelay()}")
    private void updateSearches() {
        searchService.execute();
    }

    @Scheduled(fixedDelayString = "#{@configProperties.getScheduledNotificationDelay()}")
    private void sendNotification() {
        notificationService.execute();
    }

}
