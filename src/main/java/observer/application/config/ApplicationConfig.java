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
        setWebDriverProperties();
        return new ChromeDriver(createChromeOptions(applicationProperties));
    }

    private void setWebDriverProperties() {
        if (OS.isFamilyWindows()) {
            System.setProperty("webdriver.chrome.driver", "driver-win/chromedriver.exe");
        } else if (OS.isFamilyUnix()) {
            System.setProperty("webdriver.chrome.driver", "driver-linux/chromedriver");
        }
    }

    private ChromeOptions createChromeOptions(ApplicationProperties applicationProperties) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors", "--disable-blink-features=AutomationControlled");

        if (applicationProperties.getChromedriverHeadless()) {
            options.addArguments("--headless");
        }

        if (!applicationProperties.getChromedriverImages()) {
            options.addArguments("--blink-settings=imagesEnabled=false");
        }

        return options;
    }

}