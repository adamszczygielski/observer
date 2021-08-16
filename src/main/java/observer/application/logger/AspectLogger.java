package observer.application.logger;

import lombok.extern.slf4j.Slf4j;
import observer.application.model.Search;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class AspectLogger {

    private static final String ITEM_SERVICES_POINTCUT =
            "execution(* observer.application.service.source.*.*.getItems(..))";

    private static final String REST_INVOKER_POINTCUT =
            "execution(* observer.application.rest.RestInvokerImpl.*(..))";

    private static final String DOCUMENT_SERVICE_POINTCUT =
            "execution(* observer.application.service.source.olx.DocumentService.getDocument(..))";

    @Around(ITEM_SERVICES_POINTCUT)
    public Object logItemServices(ProceedingJoinPoint joinPoint) throws Throwable {
        Search search = (Search) joinPoint.getArgs()[0];
        log.info("Sending request: {}, searchId: {}, sourceId: {}", joinPoint.getSignature().toShortString(),
                search.getId(), search.getSourceId());

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
