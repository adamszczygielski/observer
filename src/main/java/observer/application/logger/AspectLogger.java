package observer.application.logger;

import lombok.extern.slf4j.Slf4j;
import observer.application.domain.Search;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Slf4j
public class AspectLogger {

    private static final String ITEM_SERVICES_POINTCUT =
            "execution(* observer.application.service.source.*.*.getItems(..))";

    private static final String SEARCH_SERVICE_POINTCUT =
            "execution(* observer.application.service.SearchService.execute())";

    private static final String NOTIFICATION_SERVICE_POINTCUT =
            "execution(* observer.application.notification.NotificationService.execute())";

    private static final String REST_INVOKER_POINTCUT =
            "execution(* observer.application.rest.RestInvokerImpl.*(..))";

    private static final String DOCUMENT_SERVICE_POINTCUT =
            "execution(* observer.application.service.source.olx.DocumentService.getDocument(..))";

    @Around(ITEM_SERVICES_POINTCUT)
    public Object logItemServices(ProceedingJoinPoint joinPoint) throws Throwable {
        Search search = (Search) joinPoint.getArgs()[0];
        log.info("Invoking method: {}, searchId: {}, sourceId: {}", joinPoint.getSignature().toShortString(),
                search.getId(), search.getSourceId());

        return joinPoint.proceed();
    }

    @Around(SEARCH_SERVICE_POINTCUT)
    public Object logSearchService(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant startTime = Instant.now();
        Object obj = joinPoint.proceed();
        Instant endTime = Instant.now();
        log.info("{}, execution time: {} {} ", joinPoint.getSignature().toShortString(),
                Duration.between(startTime, endTime).getSeconds(), "sec.");

        return obj;
    }

    @Around(NOTIFICATION_SERVICE_POINTCUT)
    public Object logNotificationService(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Invoking method: {}", joinPoint.getSignature().toShortString());

        return joinPoint.proceed();
    }

    @Around(REST_INVOKER_POINTCUT)
    public Object logRestInvoker(ProceedingJoinPoint joinPoint) throws Throwable {
        String url = (String) joinPoint.getArgs()[0];
        log.info(url);

        return joinPoint.proceed();
    }

    @Around(DOCUMENT_SERVICE_POINTCUT)
    public Object logDocumentService(ProceedingJoinPoint joinPoint) throws Throwable {
        String url = (String) joinPoint.getArgs()[0];
        log.info(url);

        return joinPoint.proceed();
    }

}
