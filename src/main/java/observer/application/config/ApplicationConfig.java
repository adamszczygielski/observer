package observer.application.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import observer.application.rest.JsonMapper;
import observer.application.rest.JsonMapperImpl;
import observer.application.rest.RestInvoker;
import observer.application.rest.RestInvokerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public RestInvoker getRestInvoker() {
        return new RestInvokerImpl(new RestTemplate());
    }

    @Bean
    public JsonMapper getJsonMapper() {
        return new JsonMapperImpl(new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false));
    }
}