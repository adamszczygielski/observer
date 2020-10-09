package observer.application.task;

import lombok.AllArgsConstructor;
import observer.application.service.SearchService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SearchTask {

    private final SearchService searchService;

    @Scheduled(fixedDelayString = "${scheduled.delay}")
    public void updateSearch() {
        searchService.execute();
    }
}
