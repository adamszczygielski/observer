package observer.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.rest.RestInvoker;
import observer.application.webdriver.WebDriverFactory;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class DocumentService {

    private final RestInvoker restInvoker;
    private final WebDriverFactory webDriverFactory;

    public Document getDocumentByJsoup(String url) {
        Connection connection = Jsoup.connect(url).timeout(5000);
        try {
            return connection.get();
        } catch (IOException e) {
            throw new IllegalStateException("Could not fetch page content!", e);
        }
    }

    public Document getDocumentByRestTemplate(String url) {
        String html = restInvoker.get(url, null, String.class);
        return Jsoup.parse(html);
    }

    public Document getDocumentByWebDriver(String url) {
        log.info(url);
        WebDriver webDriver = webDriverFactory.getOrCreate();
        webDriver.manage().deleteAllCookies();
        webDriver.navigate().to(url);
        String html = webDriver.getPageSource();
        return Jsoup.parse(html);
    }
}
