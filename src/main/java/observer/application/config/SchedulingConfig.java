package observer.application.config;

import lombok.RequiredArgsConstructor;
import observer.application.model.Source;
import observer.application.service.RandomService;
import observer.application.service.SearchExecutionService;
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
@RequiredArgsConstructor
public class SchedulingConfig implements SchedulingConfigurer {

    private final SearchExecutionService searchExecutionService;
    private final ApplicationProperties applicationProperties;
    private final RandomService randomService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                () -> searchExecutionService.execute(Source.ALLEGRO),
                createTrigger(applicationProperties.getAllegroDelayMillis())
        );
        taskRegistrar.addTriggerTask(
                () -> searchExecutionService.execute(Source.EBAY),
                createTrigger(applicationProperties.getEbayDelayMillis())
        );
        taskRegistrar.addTriggerTask(
                () -> searchExecutionService.execute(Source.OLX),
                createTrigger(applicationProperties.getOlxDelayMillis())
        );
    }

    private Trigger createTrigger(long delayMillis) {
        return triggerContext -> {
            Instant nextExecutionTime = Optional.ofNullable(triggerContext.lastCompletionTime())
                    .orElseGet(Date::new)
                    .toInstant()
                    .plusMillis(randomService.randomize(delayMillis));

            return Date.from(nextExecutionTime);
        };
    }

}
