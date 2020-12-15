package observer.application.service.source.olx;

import lombok.AllArgsConstructor;
import observer.application.api.ParameterType;
import observer.application.api.Source;
import observer.application.domain.Item;
import observer.application.domain.Parameter;
import observer.application.domain.Search;
import observer.application.service.ItemService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static observer.application.common.Utils.now;

@Service
@AllArgsConstructor
public class OlxService extends ItemService {

    @Override
    public List<Item> getItems(Search search) {
        return fetchItems(search);
    }

    private List<Item> fetchItems(Search search) {
        ArrayList<Item> items = new ArrayList<>();

        Document document = getDocument(search);
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

    private Document getDocument(Search search) {
        Connection connection = Jsoup.connect(getRequestUrl(search));
        try {
            return connection.get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getRequestUrl(Search search) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("www.olx.pl")
                .pathSegment("oferty")
                .pathSegment("q-{keyword}")
                .path("/")
                .queryParam("search[order]", "created_at:desc")
                .queryParam("spellchecker", "off");

        List<Parameter> parameters = search.getParameterList();

        if (!CollectionUtils.isEmpty(parameters)) {
            String priceFrom = getParameterValue(parameters, ParameterType.PRICE_FROM);
            if (priceFrom != null) {
                uriComponentsBuilder.queryParam("search[filter_float_price:from]", priceFrom);
            }

            String priceTo = getParameterValue(parameters, ParameterType.PRICE_TO);
            if (priceTo != null) {
                uriComponentsBuilder.queryParam("search[filter_float_price:to]", priceTo);
            }
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
