package observer.application.config;

import lombok.RequiredArgsConstructor;
import observer.application.service.ItemNotificationService;
import observer.application.service.SearchExecutionService;
import observer.application.service.source.SourceServiceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class SchedulingConfig implements SchedulingConfigurer {

    private final SearchExecutionService searchExecutionService;
    private final ItemNotificationService itemNotificationService;
    private final SourceServiceFactory sourceServiceFactory;

    @Override
    public void configureTasks(@NonNull ScheduledTaskRegistrar taskRegistrar) {
        addSearchTask(taskRegistrar);
        addNotificationTask(taskRegistrar);
    }

    private void addSearchTask(ScheduledTaskRegistrar taskRegistrar) {
        sourceServiceFactory.getAll().forEach(sourceService ->
                taskRegistrar.addTriggerTask(() -> searchExecutionService.execute(sourceService.getSource()),
                        createTrigger(sourceService.getDelaySeconds())));
    }

    private void addNotificationTask(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(itemNotificationService::execute,
                createTrigger(itemNotificationService.getDelaySeconds()));
    }

    private Trigger createTrigger(long delaySeconds) {
        return triggerContext -> Date.from(Optional.ofNullable(triggerContext.lastCompletionTime())
                .orElseGet(Date::new)
                .toInstant()
                .plus(delaySeconds, ChronoUnit.SECONDS));
    }
}
