package observer.application.service.source.olx;

import lombok.AllArgsConstructor;
import observer.application.api.ParameterType;
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
import java.util.logging.Level;
import java.util.logging.Logger;

import static observer.application.common.Utils.now;

@Service
@AllArgsConstructor
public class OlxService extends ItemService {

    private final Logger log = Logger.getLogger(getClass().getName());

    @Override
    public List<Item> getItems(Search search) {
        return fetchItems(search);
    }

    private List<Item> fetchItems(Search search) {
        ArrayList<Item> items = new ArrayList<>();

        Document document = getDocument(search);
        if(document == null) {
            return items;
        }

        Elements noItemsInfo = document.select("h1");
        if (noItemsInfo.get(0).text().equals("Brak wyników")) {
            return items;
        }

        Elements titles = document.select("h3 > a");
        Elements prices = document.select("td > div > p > strong");
        Elements urls = document.select("h3 > a[href]");
        Elements originIds = document.select("td > div > table");

        int quantity = titles.size();
        if (prices.size() != quantity || urls.size() != quantity || originIds.size() != quantity) {
            log.log(Level.SEVERE, "Parser error while trying to fetch: " + search.getKeyword());
            return items;
        }

        for (int i = 0; i < titles.size(); i++) {
            items.add(Item.builder().originId(originIds.get(i).attr("data-id"))
                    .searchId(search.getId())
                    .dateCreated(now())
                    .title(titles.get(i).text())
                    .price(getPrice(prices.get(i).text()))
                    .url(getItemUrl(urls.get(i)))
                    .isActive(true)
                    .build());
        }

        return items;
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
                .host("www.olxoooo.pl")
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
            if (priceFrom != null) {
                uriComponentsBuilder.queryParam("search[filter_float_price:to]", priceTo);
            }
        }

        return uriComponentsBuilder
                .buildAndExpand(getKeyword(search))
                .encode(StandardCharsets.UTF_8)
                .toUriString();
    }

    private String getItemUrl(Element element) {
        String url = element.attr("href");
        int endIndex = url.indexOf("#");
        if (endIndex > 0) {
            return url.substring(0, endIndex);
        }
        return url;
    }

    private String getPrice(String price) {
        return price.replace(" ", "").replace("zł", ".00 PLN");
    }

    private String getKeyword(Search search) {
        return search.getKeyword().replaceAll(" ", "-");
    }
}
