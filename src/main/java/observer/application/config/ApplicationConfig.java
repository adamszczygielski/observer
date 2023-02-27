package observer.application.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import observer.application.rest.JsonMapper;
import observer.application.rest.JsonMapperImpl;
import observer.application.rest.RestInvoker;
import observer.application.rest.RestInvokerImpl;
import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

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

    @Bean
    public WebDriver getWebDriver(ApplicationProperties applicationProperties) {
        setWebDriverProperties(applicationProperties);
        ChromeDriver chromeDriver = new ChromeDriver(getChromeOptions(applicationProperties));
        chromeDriver.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
        return chromeDriver;
    }

    private void setWebDriverProperties(ApplicationProperties applicationProperties) {
        if (OS.isFamilyWindows()) {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        } else if (OS.isFamilyUnix()) {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        } else {
            throw new IllegalStateException("Unsupported OS!");
        }

        if (applicationProperties.getChromedriverLogging()) {
            System.setProperty("webdriver.chrome.logfile", "driver/chromedriver.log");
        }
    }

    private ChromeOptions getChromeOptions(ApplicationProperties applicationProperties) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(applicationProperties.getChromedriverArguments());
        options.setExperimentalOption("mobileEmulation", Collections.singletonMap("deviceName", "Nexus 5"));
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        return options;
    }

}