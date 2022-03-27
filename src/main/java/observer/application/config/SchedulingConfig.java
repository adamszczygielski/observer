package observer.application.config;

import lombok.RequiredArgsConstructor;
import observer.application.service.RandomService;
import observer.application.service.SearchExecutionService;
import observer.application.service.SourceServiceResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
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
    private final SourceServiceResolver sourceServiceResolver;
    private final RandomService randomService;

    @Override
    public void configureTasks(@NonNull ScheduledTaskRegistrar taskRegistrar) {
        sourceServiceResolver.getAll().forEach(s -> {
            taskRegistrar.addTriggerTask(
                    () -> searchExecutionService.execute(s.getSource()),
                    createTrigger(s.getDelay())
            );
        });
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
