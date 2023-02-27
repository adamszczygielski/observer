package observer.application.service.source.allegro;

import com.google.common.cache.LoadingCache;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.rest.JsonMapper;
import observer.application.service.RandomUtils;
import observer.application.service.source.SourceService;
import observer.application.service.source.allegro.mapper.AllegroMapper;
import observer.application.service.source.allegro.model.category.CategoryDto;
import observer.application.service.source.allegro.model.listing.Element;
import observer.application.service.source.allegro.model.listing.ListingResponse;
import org.apache.commons.text.StringEscapeUtils;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AllegroService extends SourceService {

    private static final String JSON_BEGIN_PATTERN = "__listing_StoreState\":\"";
    private static final String JSON_END_PATTERN = "\"}</script>";
    private static final List<String> FALLBACK_PATTERNS = Arrays.asList("first yellow information",
            "Przykro nam, nie znale");
    private static final short STRICT_FILTER_THRESHOLD = 5;

    private final AllegroMapper mapper = new AllegroMapper();
    private final JsonMapper jsonMapper;
    private final LoadingCache<String, List<CategoryDto>> categoryDtoCache;
    private final WebDriver webDriver;

    @Override
    public Source getSource() {
        return Source.ALLEGRO;
    }

    @Override
    public long getDelaySeconds() {
        return applicationProperties.getAllegroDelaySeconds();
    }

    @Override
    public List<Item> fetchItems(Search search) {
        String url = getRequestUrl(search);
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
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<Category> fetchCategories(String parentId) {
        return categoryDtoCache.getUnchecked(parentId).stream()
                .map(mapper::toCategory)
                .collect(Collectors.toList());
    }

    private String fetchPageSource(String url) {
        //resetBrowser();
        log.info(url);
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
            webDriver.manage().deleteAllCookies();
            throw new IllegalArgumentException("Json begin index has not been found!");
        }
        return beginPatternIndex + JSON_BEGIN_PATTERN.length();
    }

    private int getJsonEndIndex(String pageSource, int jsonBeginIndex) {
        int endPatternIndex = pageSource.indexOf(JSON_END_PATTERN, jsonBeginIndex);
        if (endPatternIndex == -1) {
            webDriver.manage().deleteAllCookies();
            throw new IllegalArgumentException("Json end index has not been found!");
        }
        return endPatternIndex;
    }

    private String getRequestUrl(Search search) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("allegro.pl");

        String categoryId = search.getCategoryId();
        if (categoryId != null) {
            uriComponentsBuilder.pathSegment("kategoria");
            uriComponentsBuilder.path(categoryId);
        } else {
            uriComponentsBuilder.path("listing");
        }

        uriComponentsBuilder.queryParam("string",
                        RandomUtils.randomizeCase(search.getKeyword()).replaceAll(" ", "%20"))
                .queryParam("order", "n")
                .queryParam("strategy", "NO_FALLBACK")
                .queryParam("ref", "dym-redirect")
                .queryParam("price_from", randomizePriceFrom(search.getPriceFrom()))
                .queryParam("price_to", randomizePriceTo(search.getPriceTo()));

        return uriComponentsBuilder.build().toUriString();
    }

    private boolean containsAllKeywords(String title, String keyword) {
        List<String> keywords = Arrays.asList(keyword.split(" "));
        String normalizedTitle = title.replace(" ", "")
                .replace("-", "")
                .toLowerCase(Locale.ROOT);
        return keywords.stream().allMatch(normalizedTitle::contains);
    }

    private static double randomizePriceFrom(Integer priceFrom) {
        return priceFrom == null ?
                RandomUtils.getInt(0, 99) / 100d :
                priceFrom + RandomUtils.getInt(0, 99) / 100d;
    }

    private static double randomizePriceTo(Integer priceTo) {
        return priceTo == null ?
                RandomUtils.getInt(100_000_000, 200_000_000) / 100d :
                priceTo + RandomUtils.getInt(0, 99) / 100d;
    }

    private void resetBrowser() {
        webDriver.navigate().to("about:blank");
        webDriver.manage().deleteAllCookies();
    }

}