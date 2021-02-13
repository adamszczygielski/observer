package observer.application.task;

import lombok.RequiredArgsConstructor;
import observer.application.service.SearchService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchTask {

    private final SearchService searchService;

    @Scheduled(fixedDelayString = "${observer.scheduled.delay}")
    public void updateSearch() {
        searchService.execute();
    }
}
