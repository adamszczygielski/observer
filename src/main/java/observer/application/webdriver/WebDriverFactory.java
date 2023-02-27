package observer.application.webdriver;

import org.openqa.selenium.WebDriver;

public interface WebDriverFactory {

    WebDriver getOrCreate();
}
