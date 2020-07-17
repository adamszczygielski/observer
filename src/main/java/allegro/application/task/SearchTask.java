package allegro.application.task;

import allegro.application.service.SearchExecutor;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

import static allegro.application.common.Utils.now;

@Component
@AllArgsConstructor
public class SearchTask {

    private final SearchExecutor searchExecutor;
    private final Logger log = Logger.getLogger(getClass().getName());

    @Scheduled(fixedDelayString = "${scheduled.delay}")
    public void updateSearch() {
        log.log(Level.INFO, "Job started at: " + now());
        searchExecutor.executeAll();
        log.log(Level.INFO, "Job finished at: " + now());
    }
}
