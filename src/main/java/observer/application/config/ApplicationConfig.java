package observer.application.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import observer.application.logger.AspectLogger;
import observer.application.rest.RestInvoker;
import observer.application.rest.RestInvokerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean("restInvoker")
    public RestInvoker getRestInvoker() {
        return new RestInvokerImpl(new RestTemplate());
    }

    @Bean("aspectLogger")
    public AspectLogger getAspectLogger() {
        return new AspectLogger();
    }

    @Bean("objectMapper")
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

}