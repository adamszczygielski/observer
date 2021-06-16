package observer.application.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.WebClient;
import observer.application.logger.AspectLogger;
import observer.application.rest.RestInvoker;
import observer.application.rest.RestInvokerImpl;
import org.apache.http.auth.AuthScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
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

    @Bean("webClient")
    public WebClient getWebClient(ApplicationProperties properties) {
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX);

        if (!StringUtils.isEmpty(properties.getProxyHost())) {
            DefaultCredentialsProvider credentialsProvider = new DefaultCredentialsProvider();

            credentialsProvider.addCredentials(properties.getProxyUsername(), properties.getProxyPassword(),
                    properties.getProxyHost(), properties.getProxyPort(), AuthScope.ANY_REALM);

            webClient.setCredentialsProvider(credentialsProvider);
        }

        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setDownloadImages(false);
        webClient.getOptions().setAppletEnabled(false);
        webClient.getOptions().setRedirectEnabled(true);
        return webClient;
    }

}