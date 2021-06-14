package observer.application.service.source.allegro;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.cache.LoadingCache;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.config.ApplicationProperties;
import observer.application.domain.Category;
import observer.application.domain.Item;
import observer.application.domain.Search;
import observer.application.service.ItemService;
import observer.application.service.source.allegro.mapper.AllegroMapper;
import observer.application.service.source.allegro.model.category.CategoryDto;
import observer.application.service.source.allegro.model.listing.Element;
import observer.application.service.source.allegro.model.listing.ListingResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
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
    private final WebClient webClient;
    private final ApplicationProperties properties;
    private final Gson gson = new Gson();

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
        String listingJson = "{}";
        try {
            randomizedDelay(properties.getAllegroDelayMillis());
            HtmlPage htmlPage = webClient.getPage(url);
            String pageContent = htmlPage.getPage().asXml();
            listingJson = pageContent.substring(pageContent.indexOf(JSON_START_PATTERN) + JSON_START_PATTERN.length(),
                    pageContent.indexOf(JSON_END_PATTERN))
                    .replace("\\u002F", "/")
                    .replace("\\\\\\\"", " ")
                    .replace("\\\"", "\"");

        } catch (IOException e) {
            log.error("Error while fetching elements", e);
        } finally {
            webClient.close();
        }

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

        uriComponentsBuilder.queryParam("string", search.getKeyword()
                .replaceAll(" ", "%20"))
                .queryParam("order", "n")
                .queryParam("strategy", "NO_FALLBACK")
                .queryParam("ref","dym-redirect");

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

}