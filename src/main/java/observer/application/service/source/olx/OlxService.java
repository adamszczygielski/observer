package observer.application.service.source.olx;

import com.google.common.cache.LoadingCache;
import lombok.AllArgsConstructor;
import observer.application.api.Source;
import observer.application.domain.Category;
import observer.application.domain.Item;
import observer.application.domain.Search;
import observer.application.service.ItemService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static observer.application.common.Utils.now;

@Service
@AllArgsConstructor
public class OlxService extends ItemService {

    private final LoadingCache<String, List<Category>> categoryCache;
    private final DocumentService documentService;

    @Override
    public List<Item> getItems(Search search) {
        return fetchItems(search);
    }

    @Override
    public List<Category> getCategories(String parentId) {
        return categoryCache.getUnchecked(parentId);
    }

    private List<Item> fetchItems(Search search) {
        ArrayList<Item> items = new ArrayList<>();
        String url = getRequestUrl(search);

        Document document = documentService.getDocument(url);
        if (document == null || !containsItems(document)) {
            return items;
        }

        Elements titles = document.select("h3 > a");
        Elements prices = document.select("td > div > p > strong");
        Elements urls = document.select("h3 > a[href]");
        Elements originIds = document.select("td > div > table");

        for (int i = 0; i < titles.size(); i++) {
            items.add(Item.builder().originId(originIds.get(i).attr("data-id"))
                    .searchId(search.getId())
                    .dateCreated(now())
                    .title(titles.get(i).text())
                    .price(toPrice(prices.get(i)))
                    .url(toItemUrl(urls.get(i)))
                    .isActive(true)
                    .isNotified(false)
                    .sourceId(Source.OLX.getId())
                    .build());
        }

        return items;
    }

    private boolean containsItems(Document document) {
        Elements noItemsResponse = document.select("#body-container > div > div > div > p");
        return noItemsResponse.size() != 1;
    }

    private String getRequestUrl(Search search) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("www.olx.pl");

        if (search.getCategoryId() != null) {
            uriComponentsBuilder.pathSegment(search.getCategoryId());
        } else {
            uriComponentsBuilder.pathSegment("oferty");
        }

        uriComponentsBuilder.pathSegment("q-{keyword}")
                .path("/")
                .queryParam("search[order]", "created_at:desc")
                .queryParam("spellchecker", "off");

        Integer priceFrom = search.getPriceFrom();
        if (priceFrom != null) {
            uriComponentsBuilder.queryParam("search[filter_float_price:from]", priceFrom);
        }

        Integer priceTo = search.getPriceTo();
        if (priceTo != null) {
            uriComponentsBuilder.queryParam("search[filter_float_price:to]", priceTo);
        }

        return uriComponentsBuilder
                .buildAndExpand(toKeyword(search))
                .encode(StandardCharsets.UTF_8)
                .toUriString();
    }

    private String toItemUrl(Element element) {
        String url = element.attr("href");
        int endIndex = url.indexOf("#");
        if (endIndex > 0) {
            return url.substring(0, endIndex);
        }
        return url;
    }

    private String toPrice(Element element) {
        return element.text().replace(" ", "").replace("zł", ".00 PLN");
    }

    private String toKeyword(Search search) {
        return search.getKeyword().replaceAll(" ", "-");
    }
}
