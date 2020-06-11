package allegro.application.task;

import allegro.application.service.SearchUpdateService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@AllArgsConstructor
public class SearchTask {

    private final SearchUpdateService searchUpdateService;
    private final Logger log = Logger.getLogger(getClass().getName());

    @Scheduled(fixedDelayString = "${scheduled.delay}")
    public void updateSearch() {
        log.log(Level.INFO, "---------- Job started at: " + new Timestamp(System.currentTimeMillis()));
        searchUpdateService.execute();
        log.log(Level.INFO, "---------- Job finished at: " + new Timestamp(System.currentTimeMillis()));
    }
}
