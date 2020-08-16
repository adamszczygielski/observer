package observer.application.task;

import lombok.AllArgsConstructor;
import observer.application.service.SearchExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SearchTask {

    private final SearchExecutor searchExecutor;

    @Scheduled(fixedDelayString = "${scheduled.delay}")
    public void updateSearch() {
        searchExecutor.executeAll();
    }
}
