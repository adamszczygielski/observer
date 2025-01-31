package observer.application.service.source.allegro;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.config.ApplicationConfig;
import observer.application.dto.Source;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.rest.JsonMapper;
import observer.application.service.RandomUtils;
import observer.application.service.source.SourceService;
import observer.application.service.source.allegro.mapper.AllegroMapper;
import observer.application.service.source.allegro.model.listing.ListingResponse;
import observer.application.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AllegroService implements SourceService {

    private static final String JSON_BEGIN_PATTERN = "{\"listingType\":\"base-mobile\",\"__listing_StoreState";
    private static final String JSON_END_PATTERN = "</script>";
    private static final List<String> FALLBACK_PATTERNS = Arrays.asList("first yellow information",
            "Przykro nam, nie znale");

    private final ApplicationConfig applicationConfig;
    private final JsonMapper jsonMapper;
    private final WebDriverFactory webDriverFactory;
    private final AllegroMapper mapper = new AllegroMapper();

    @Override
    public Source getSource() {
        return Source.ALLEGRO;
    }

    @Override
    public Duration getDelay() {
        return applicationConfig.getAllegroDelay().plus(RandomUtils.getInt(0, 5), ChronoUnit.SECONDS);
    }

    @Override
    public List<Item> fetchItems(Search search) {
        String pageSource = fetchPageSource(search.getParams());
        if (FALLBACK_PATTERNS.stream().anyMatch(pageSource::contains)) {
            return Collections.emptyList();
        }

        String listingResponseJson = getListingResponseJson(pageSource);
        ListingResponse listingResponse = jsonMapper.toObject(listingResponseJson, ListingResponse.class);

        List<String> keywords = extractKeywords(search.getParams());

        return listingResponse.getListingStoreState().getItems().getElements().stream()
                .filter(element -> element.getId() != null)
                .filter(element -> !element.getType().equals("banner"))
                .filter(element -> keywords.stream().anyMatch(k -> element.getTitle().getText().toLowerCase()
                        .replaceAll(" ", "").replaceAll("-", "").contains(k)))
                .map(element -> mapper.toItem(element, search.getId()))
                .distinct()
               .toList();
    }

    private String fetchPageSource(String url) {
        log.info(url);
        WebDriver webDriver = webDriverFactory.getOrCreate();
        webDriver.manage().deleteAllCookies();
        webDriver.navigate().to(url);
        return webDriver.getPageSource();
    }

    private String getListingResponseJson(String pageSource) {
        int jsonBeginIndex = getJsonBeginIndex(pageSource);
        int jsonEndIndex = getJsonEndIndex(pageSource, jsonBeginIndex);
        return pageSource.substring(jsonBeginIndex, jsonEndIndex);
    }

    private int getJsonBeginIndex(String pageSource) {
        int beginPatternIndex = pageSource.indexOf(JSON_BEGIN_PATTERN);
        if (beginPatternIndex == -1) {
            throw new IllegalArgumentException("Json begin index has not been found!");
        }
        return beginPatternIndex;
    }

    private int getJsonEndIndex(String pageSource, int jsonBeginIndex) {
        int endPatternIndex = pageSource.indexOf(JSON_END_PATTERN, jsonBeginIndex);
        if (endPatternIndex == -1) {
            throw new IllegalArgumentException("Json end index has not been found!");
        }
        return endPatternIndex;
    }

    private List<String> extractKeywords(String url) {
        int beginIndex = url.indexOf("string=");
        if (beginIndex == -1) {
            return List.of();
        } else {
            beginIndex += 7;
        }

        int endIndex = url.indexOf("&", beginIndex);
        if (endIndex == -1) {
            endIndex = url.length();
        }

        String[] keywords = url.substring(beginIndex, endIndex)
                .toLowerCase()
                .split("%20");

        return List.of(keywords);
    }
}
