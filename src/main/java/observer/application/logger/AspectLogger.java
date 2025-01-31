package observer.application.logger;

import lombok.extern.slf4j.Slf4j;
import observer.application.model.Search;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class AspectLogger {

    private static final String SOURCE_SERVICE_POINTCUT =
            "execution(* observer.application.service.source.SourceService.fetchItems(..))";

    @Around(SOURCE_SERVICE_POINTCUT)
    public Object logSourceService(ProceedingJoinPoint joinPoint) throws Throwable {
        Search search = (Search) joinPoint.getArgs()[0];
        log.info(search.toString());
        return joinPoint.proceed();
    }
}
