package observer.application.config;

import observer.application.rest.RestInvoker;
import observer.application.rest.RestInvokerImpl;
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

    @Bean("webDriver")
    public WebDriver getWebDriver(ApplicationProperties properties) {
        setWebDriverProperties();
        return new ChromeDriver(createChromeOptions(properties));
    }

    private void setWebDriverProperties() {
        if (OS.isFamilyWindows()) {
            System.setProperty("webdriver.chrome.driver", "driver-win/chromedriver.exe");
        } else if (OS.isFamilyUnix()) {
            System.setProperty("webdriver.chrome.driver", "driver-linux/chromedriver");
        }
    }

    private ChromeOptions createChromeOptions(ApplicationProperties properties) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors", "--disable-blink-features=AutomationControlled");

        String[] proxies = properties.getProxies();
        if (proxies.length > 0) {
            Proxy proxy = new Proxy();
            proxy.setSslProxy((String) Array.get(proxies, 0));
            options.setProxy(proxy);
        }

        if (properties.getChromedriverHeadless()) {
            options.addArguments("--headless");
        }

        if (!properties.getChromedriverImages()) {
            options.addArguments("--blink-settings=imagesEnabled=false");
        }

        return options;
    }

}