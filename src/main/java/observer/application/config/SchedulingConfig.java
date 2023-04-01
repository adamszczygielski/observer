package observer.application.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.model.Source;
import observer.application.service.ItemNotificationService;
import observer.application.service.NotificationService;
import observer.application.service.SearchExecutionService;
import observer.application.service.source.SourceServiceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.text.MessageFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;
import java.util.function.Supplier;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class SchedulingConfig implements SchedulingConfigurer {

    private static final String ERROR_MESSAGE_PATTERN =
            "Error threshold for {0} exceeded. Next execution attempt in {1} minutes";

    private final SearchExecutionService searchExecutionService;
    private final ItemNotificationService itemNotificationService;
    private final NotificationService notificationService;
    private final SourceServiceFactory sourceServiceFactory;
    private final ApplicationConfig applicationConfig;

    @Override
    public void configureTasks(@NonNull ScheduledTaskRegistrar taskRegistrar) {
        addSearchTasks(taskRegistrar);
        addNotificationTask(taskRegistrar);
    }

    private void addSearchTasks(ScheduledTaskRegistrar taskRegistrar) {
        sourceServiceFactory.getAll().forEach(sourceService ->
                taskRegistrar.addTriggerTask(
                        () -> searchExecutionService.execute(sourceService.getSource()),
                        createTrigger(() -> estimateDelaySeconds(sourceService.getSource()))));
    }

    private void addNotificationTask(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(itemNotificationService::execute,
                createTrigger(itemNotificationService::getDelaySeconds));
    }

    private Trigger createTrigger(Supplier<Long> delay) {
        return triggerContext -> Date.from(Optional.ofNullable(triggerContext.lastCompletionTime())
                .orElseGet(Date::new)
                .toInstant()
                .plus(delay.get(), ChronoUnit.SECONDS));
    }

    private long estimateDelaySeconds(Source source) {
        int errorCount = searchExecutionService.getErrorCount(source.getId());
        int threshold = applicationConfig.getSearchesErrorThreshold();

        if (errorCount <= threshold) {
            return sourceServiceFactory.get(source).getDelaySeconds();
        }
        int delayMinutes = applicationConfig.getSearchesErrorDelayMinutes() * (errorCount - threshold);
        String errorMessage = MessageFormat.format(ERROR_MESSAGE_PATTERN, source.getLabel(), delayMinutes);
        log.error(errorMessage);
        notificationService.sendNotification(errorMessage);
        return delayMinutes * 60L;
    }
}
