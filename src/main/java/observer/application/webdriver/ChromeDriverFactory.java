package observer.application.webdriver;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.config.ApplicationProperties;
import org.apache.commons.exec.OS;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChromeDriverFactory implements WebDriverFactory {

    private final ApplicationProperties applicationProperties;
    private ChromeDriver chromeDriver;

    @Override
    public WebDriver getOrCreate() {
        if (chromeDriver == null) {
            create();
        } else {
            try {
                chromeDriver.getTitle();
            } catch (NoSuchWindowException e) {
                recreate();
            }
        }
        return chromeDriver;
    }

    private void create() {
        setWebDriverSystemProperties();
        chromeDriver = new ChromeDriver(getChromeOptions());
        chromeDriver.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
    }

    private void recreate() {
        stopChromeProcess();
        chromeDriver = new ChromeDriver(getChromeOptions());
        chromeDriver.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
    }

    private void setWebDriverSystemProperties() {
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

    private void stopChromeProcess() {
        try {
            if (OS.isFamilyWindows()) {
                Runtime.getRuntime().exec("taskkill /IM chrome.exe /F");
            } else if (OS.isFamilyUnix()) {
                Runtime.getRuntime().exec("pkill chrome");
            }
        } catch (IOException e) {
            log.error("Could not stop chrome process!", e);
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(applicationProperties.getChromedriverArguments());
        options.setExperimentalOption("mobileEmulation", Collections.singletonMap("deviceName", "Nexus 5"));
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        return options;
    }
}
