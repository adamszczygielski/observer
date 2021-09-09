package observer.application.service.source.allegro;

import com.google.common.cache.LoadingCache;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.service.ItemService;
import observer.application.service.RandomService;
import observer.application.service.source.allegro.mapper.AllegroMapper;
import observer.application.service.source.allegro.model.category.CategoryDto;
import observer.application.service.source.allegro.model.listing.Element;
import observer.application.service.source.allegro.model.listing.ListingResponse;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AllegroService extends ItemService {

    private static final String JSON_START_PATTERN = "__listing_StoreState\":\"";
    private static final String JSON_END_PATTERN = "\",\"__listing_CookieMonster";

    private final AllegroMapper mapper;
    private final LoadingCache<String, List<CategoryDto>> categoryDtoCache;
    private final WebDriver webDriver;
    private final Gson gson = new Gson();
    private final RandomService randomService;

    @Override
    public List<Item> getItems(Search search) {
        String url = getRequestUrl(search);
        List<Element> elements = getElements(url);
        return mapper.toItems(elements, search.getId());
    }

    @Override
    public List<Category> getCategories(String parentId) {
        List<CategoryDto> categories = categoryDtoCache.getUnchecked(parentId);
        return mapper.toCategories(categories);
    }

    private List<Element> getElements(String url) {
        log.info(url);
        randomizeBrowser();
        webDriver.navigate().to(url);
        String pageContent = webDriver.getPageSource();

        int beginIndex = pageContent.indexOf(JSON_START_PATTERN) + JSON_START_PATTERN.length();
        int endIndex = pageContent.indexOf(JSON_END_PATTERN);

        if (endIndex == -1) {
            webDriver.navigate().to("about:blank");
            throw new IllegalArgumentException("No json found in page content!");
        }

        String listingJson = pageContent.substring(beginIndex, endIndex)
                .replace("\\u002F", "/")
                .replace("\\\\\\\"", " ")
                .replace("\\\"", "\"");

        webDriver.navigate().to("about:blank");

        return gson.fromJson(listingJson, ListingResponse.class).getItems().getElements().stream()
                .filter(element -> element.getId() != null)
                .collect(Collectors.toList());
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