package observer.application.service.source.allegro;

import com.google.common.cache.LoadingCache;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.service.RandomService;
import observer.application.service.source.SourceService;
import observer.application.service.source.allegro.mapper.AllegroMapper;
import observer.application.service.source.allegro.model.category.CategoryDto;
import observer.application.service.source.allegro.model.listing.Element;
import observer.application.service.source.allegro.model.listing.ListingResponse;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AllegroService extends SourceService {

    private static final String JSON_BEGIN_PATTERN = "__listing_StoreState\":\"";
    private static final String JSON_END_PATTERN = "}\"}</script>";
    private static final String FALLBACK_PATTERN = "first yellow information";

    private final AllegroMapper mapper;
    private final LoadingCache<String, List<CategoryDto>> categoryDtoCache;
    private final WebDriver webDriver;
    private final Gson gson = new Gson();
    private final RandomService randomService;

    @Override
    public Source getSource() {
        return Source.ALLEGRO;
    }

    @Override
    public long getDelay() {
        return applicationProperties.getAllegroDelaySeconds();
    }

    @Override
    public List<Item> fetchItems(Search search) {
        String url = getRequestUrl(search);
        String pageSource = fetchPageSource(url);
        return getListingResponseJson(pageSource)
                .map(json -> mapper.toItems(getElements(json), search.getId()))
                .orElse(Collections.emptyList());
    }

    @Override
    public List<Category> fetchCategories(String parentId) {
        List<CategoryDto> categories = categoryDtoCache.getUnchecked(parentId);
        return mapper.toCategories(categories);
    }

    private String fetchPageSource(String url) {
        log.info(url);
        randomizeBrowser();
        webDriver.navigate().to(url);
        String pageSource = webDriver.getPageSource();
        webDriver.navigate().to("about:blank");
        return pageSource;
    }

    private List<Element> getElements(String listingResponseJson) {
        return gson.fromJson(listingResponseJson, ListingResponse.class)
                .getItems().getElements().stream()
                .filter(element -> element.getId() != null)
                .collect(Collectors.toList());
    }

    private Optional<String> getListingResponseJson(String pageContent) {
        if (pageContent.contains(FALLBACK_PATTERN)) {
            return Optional.empty();
        }

        int beginPatternIndex = pageContent.indexOf(JSON_BEGIN_PATTERN);
        if (beginPatternIndex == -1) {
            throw new IllegalArgumentException("Json begin index has not been found!");
        }

        int endPatternIndex = pageContent.indexOf(JSON_END_PATTERN, beginPatternIndex);
        if (endPatternIndex == -1) {
            throw new IllegalArgumentException("Json end index has not been found!");
        }

        int jsonBeginIndex = beginPatternIndex + JSON_BEGIN_PATTERN.length();
        int jsonEndIndex = endPatternIndex + 1;
        String json = pageContent.substring(jsonBeginIndex, jsonEndIndex)
                .replace("\\u002F", "/")
                .replace("\\\\\\\"", " ")
                .replace("\\\"", "\"");

        return Optional.of(json);
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

        uriComponentsBuilder.queryParam("string", randomService.randomizeCase(search.getKeyword())
                .replaceAll(" ", "%20"))
                .queryParam("order", "n")
                .queryParam("strategy", "NO_FALLBACK")
                .queryParam("ref", "dym-redirect");

        Integer priceFrom = search.getPriceFrom();
        if (priceFrom != null) {
            uriComponentsBuilder.queryParam("price_from", priceFrom);
        }

        Integer priceTo = search.getPriceTo();
        if (priceTo != null) {
            uriComponentsBuilder.queryParam("price_to", priceTo);
        }

        return uriComponentsBuilder.build().toUriString();
    }

    private void randomizeBrowser() {
        webDriver.manage().window().setSize(randomService.getDimension());
    }

}