package observer.application.config;

import lombok.RequiredArgsConstructor;
import observer.application.service.RandomUtils;
import observer.application.service.SearchExecutionService;
import observer.application.service.source.SourceServiceResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class SchedulingConfig implements SchedulingConfigurer {

    private final int END_OF_NIGHTTIME_HOUR = 6;

    private final SearchExecutionService searchExecutionService;
    private final SourceServiceResolver sourceServiceResolver;

    @Override
    public void configureTasks(@NonNull ScheduledTaskRegistrar taskRegistrar) {
        sourceServiceResolver.getAll().forEach(sourceService -> {
            taskRegistrar.addTriggerTask(
                    () -> searchExecutionService.execute(sourceService.getSource()),
                    createTrigger(sourceService.getDelaySeconds())
            );
        });
    }

    private Trigger createTrigger(long delaySeconds) {
        return triggerContext -> {
            Instant nextExecutionTime = Optional.ofNullable(triggerContext.lastCompletionTime())
                    .orElseGet(Date::new)
                    .toInstant()
                    .plus(RandomUtils.randomize(delaySeconds, delaySeconds * 0.3), ChronoUnit.SECONDS);

            int nextExecutionHour = nextExecutionTime.atOffset(ZoneOffset.from(OffsetDateTime.now())).getHour();
            if (nextExecutionHour < END_OF_NIGHTTIME_HOUR) {
                return Date.from(nextExecutionTime.plus(END_OF_NIGHTTIME_HOUR - nextExecutionHour, ChronoUnit.HOURS));
            }
            return Date.from(nextExecutionTime);
        };
    }

}
