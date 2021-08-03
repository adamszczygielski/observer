package observer.application.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import observer.application.logger.AspectLogger;
import observer.application.rest.RestInvoker;
import observer.application.rest.RestInvokerImpl;
import observer.application.service.RandomService;
import org.apache.commons.exec.OS;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;

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

    @Bean("webDriver")
    public WebDriver getWebDriver(ApplicationProperties properties, RandomService randomService) {
        if (OS.isFamilyWindows()) {
            System.setProperty("webdriver.chrome.driver", "driver-win/chromedriver.exe");
        } else if (OS.isFamilyUnix()) {
            System.setProperty("webdriver.chrome.driver", "driver-linux/chromedriver");
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                randomService.getUserAgentArg(),
                randomService.getWindowSizeArg(),
                "--ignore-certificate-errors",
                "--disable-blink-features=AutomationControlled"
        );

        if (!properties.getChromedriverImages()) {
            options.addArguments("--blink-settings=imagesEnabled=false");
        }

        String[] proxies = properties.getProxies();
        if (proxies.length > 0) {
            Proxy proxy = new Proxy();
            proxy.setSslProxy((String) Array.get(proxies, 0));
            options.setProxy(proxy);
        }

        if (properties.getChromedriverHeadless()) {
            options.addArguments("--headless");
        }

        return new ChromeDriver(options);
    }

}