package observer.application.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;

import java.net.URL;
import java.util.List;
import java.util.Set;

public class MockWebDriver implements WebDriver {

    private String pageSource = "";

    public void setPageSource(String pageSource) {
        this.pageSource = pageSource;
    }

    @Override
    public void get(String s) {

    }

    @Override
    public String getCurrentUrl() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public String getPageSource() {
        return this.pageSource;
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {

    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return null;
    }

    @Override
    public TargetLocator switchTo() {
        return null;
    }

    @Override
    public Navigation navigate() {
        return new MockNavigation();
    }

    @Override
    public Options manage() {
        return new MockOptions();
    }

    private class MockOptions implements Options {

        @Override
        public void addCookie(Cookie cookie) {

        }

        @Override
        public void deleteCookieNamed(String s) {

        }

        @Override
        public void deleteCookie(Cookie cookie) {

        }

        @Override
        public void deleteAllCookies() {

        }

        @Override
        public Set<Cookie> getCookies() {
            return null;
        }

        @Override
        public Cookie getCookieNamed(String s) {
            return null;
        }

        @Override
        public Timeouts timeouts() {
            return null;
        }

        @Override
        public ImeHandler ime() {
            return null;
        }

        @Override
        public Window window() {
            return null;
        }

        @Override
        public Logs logs() {
            return null;
        }
    }

    private class MockNavigation implements Navigation {

        @Override
        public void back() {

        }

        @Override
        public void forward() {

        }

        @Override
        public void to(String s) {

        }

        @Override
        public void to(URL url) {

        }

        @Override
        public void refresh() {

        }
    }
}
