package observer.application.service.source.allegro;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.config.ApplicationConfig;
import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.rest.JsonMapper;
import observer.application.service.RandomUtils;
import observer.application.service.source.SourceService;
import observer.application.service.source.allegro.mapper.AllegroMapper;
import observer.application.service.source.allegro.model.listing.Element;
import observer.application.service.source.allegro.model.listing.ListingResponse;
import observer.application.webdriver.WebDriverFactory;
import org.apache.commons.text.StringEscapeUtils;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AllegroService implements SourceService {

    private static final String JSON_BEGIN_PATTERN = "__listing_StoreState\":\"";
    private static final String JSON_END_PATTERN = "\"}</script>";
    private static final List<String> FALLBACK_PATTERNS = Arrays.asList("first yellow information",
            "Przykro nam, nie znale");
    private static final short STRICT_FILTER_THRESHOLD = 5;

    private final ApplicationConfig applicationConfig;
    private final JsonMapper jsonMapper;
    private final AllegroCategoryService allegroCategoryService;
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
        String url = mapper.toUrl(search);
        String pageSource = fetchPageSource(url);
        if (FALLBACK_PATTERNS.stream().anyMatch(pageSource::contains)) {
            return Collections.emptyList();
        }

        String listingResponseJson = getListingResponseJson(pageSource);
        List<Element> elements = getElements(listingResponseJson);
        if (elements.size() > STRICT_FILTER_THRESHOLD) {
            return elements.stream()
                    .filter(e -> containsAllKeywords(e.getTitle().getText(), search.getKeyword()))
                    .map(element -> mapper.toItem(element, search.getId()))
                    .collect(Collectors.toList());
        } else {
            return elements.stream()
                    .map(element -> mapper.toItem(element, search.getId()))
                    .distinct()
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<Category> fetchCategories(String parentId) {
        return allegroCategoryService.fetchCategories(parentId).stream()
                .map(mapper::toCategory)
                .collect(Collectors.toList());
    }

    private String fetchPageSource(String url) {
        log.info(url);
        WebDriver webDriver = webDriverFactory.getOrCreate();
        webDriver.manage().deleteAllCookies();
        webDriver.navigate().to(url);
        return webDriver.getPageSource();
    }

    private List<Element> getElements(String listingResponseJson) {
        return jsonMapper.toObject(listingResponseJson, ListingResponse.class)
                .getItems().getElements().stream()
                .filter(element -> element.getId() != null)
                .filter(element -> !element.getType().equals("banner"))
                .collect(Collectors.toList());
    }

    private String getListingResponseJson(String pageSource) {
        int jsonBeginIndex = getJsonBeginIndex(pageSource);
        int jsonEndIndex = getJsonEndIndex(pageSource, jsonBeginIndex);
        String unescapedJson = pageSource.substring(jsonBeginIndex, jsonEndIndex);
        return StringEscapeUtils.unescapeJson(unescapedJson);
    }

    private int getJsonBeginIndex(String pageSource) {
        int beginPatternIndex = pageSource.indexOf(JSON_BEGIN_PATTERN);
        if (beginPatternIndex == -1) {
            throw new IllegalArgumentException("Json begin index has not been found!");
        }
        return beginPatternIndex + JSON_BEGIN_PATTERN.length();
    }

    private int getJsonEndIndex(String pageSource, int jsonBeginIndex) {
        int endPatternIndex = pageSource.indexOf(JSON_END_PATTERN, jsonBeginIndex);
        if (endPatternIndex == -1) {
            throw new IllegalArgumentException("Json end index has not been found!");
        }
        return endPatternIndex;
    }

    private boolean containsAllKeywords(String title, String keyword) {
        List<String> keywords = Arrays.asList(keyword.split(" "));
        String normalizedTitle = title.replace(" ", "")
                .replace("-", "")
                .toLowerCase(Locale.ROOT);
        return keywords.stream().allMatch(normalizedTitle::contains);
    }
}