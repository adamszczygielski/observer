package observer.application.webdriver;

import org.openqa.selenium.WebDriver;

public class MockDriverFactory implements WebDriverFactory {

    private final MockWebDriver mockWebDriver = new MockWebDriver();

    @Override
    public WebDriver getOrCreate() {
        return mockWebDriver;
    }

    public void setPageSource(String pageSource) {
        mockWebDriver.setPageSource(pageSource);
    }
}
