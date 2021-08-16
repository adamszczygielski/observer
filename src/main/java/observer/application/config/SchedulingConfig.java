package observer.application.config;

import observer.application.model.Source;
import observer.application.service.RandomService;
import observer.application.service.SearchUpdateService;
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
    private SearchUpdateService searchUpdateService;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private RandomService randomService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                () -> searchUpdateService.invoke(Source.ALLEGRO),
                createTrigger(applicationProperties.getAllegroDelayMillis())
        );
        taskRegistrar.addTriggerTask(
                () -> searchUpdateService.invoke(Source.EBAY),
                createTrigger(applicationProperties.getEbayDelayMillis())
        );
        taskRegistrar.addTriggerTask(
                () -> searchUpdateService.invoke(Source.OLX),
                createTrigger(applicationProperties.getOlxDelayMillis())
        );
    }

    private Trigger createTrigger(long millis) {
        return triggerContext -> {
            Optional<Date> lastCompletionTime = Optional.ofNullable(triggerContext.lastCompletionTime());
            Instant nextExecutionTime = lastCompletionTime.orElseGet(Date::new)
                    .toInstant()
                    .plusMillis(randomService.getDelay(millis));

            return Date.from(nextExecutionTime);
        };
    }

}
