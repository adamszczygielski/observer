package observer.application.config;

import observer.application.domain.Source;
import observer.application.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Configuration
@EnableScheduling
public class SchedulingConfig implements SchedulingConfigurer {

    @Autowired
    SearchService searchService;

    @Autowired
    ApplicationProperties applicationProperties;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                () -> searchService.invoke(Source.ALLEGRO),
                createTrigger(applicationProperties.getAllegroDelayMillis())
        );
        taskRegistrar.addTriggerTask(
                () -> searchService.invoke(Source.EBAY),
                createTrigger(applicationProperties.getEbayDelayMillis())
        );
        taskRegistrar.addTriggerTask(
                () -> searchService.invoke(Source.OLX),
                createTrigger(applicationProperties.getOlxDelayMillis())
        );
    }

    private Trigger createTrigger(Long millis) {
        return triggerContext -> {
            Optional<Date> lastCompletionTime = Optional.ofNullable(triggerContext.lastCompletionTime());
            long randomizedDelay = randomizeDelay(millis);
            Instant nextExecutionTime = lastCompletionTime.orElseGet(Date::new)
                    .toInstant()
                    .plusMillis(randomizedDelay);

            return Date.from(nextExecutionTime);
        };
    }

    private long randomizeDelay(long millis) {
        if (millis > 0) {
            return (long) (millis + Math.random() * millis / 2);
        }
        return millis;
    }

}
