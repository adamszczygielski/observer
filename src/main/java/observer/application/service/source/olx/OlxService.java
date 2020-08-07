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
        Connection connection = Jsoup.connect(getRequestUrl(search));
        Document document = null;
        try {
            document = connection.get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements noItemsInfo = document.select("p > span");
        if (noItemsInfo.get(0).text().equals("Sprawdź poprawność albo spróbuj bardziej ogólnego zapytania")) {
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

    private String getRequestUrl(Search search) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("www.olx.pl")
                .pathSegment("oferty")
                .pathSegment("q-{keyword}")
                .path("/")
                .queryParam("search%5Border%5D", "created_at%3Adesc")
                .queryParam("spellchecker", "off");

        List<Parameter> parameters = search.getParameterList();

        if (!CollectionUtils.isEmpty(parameters)) {
            String priceFrom = getParameterValue(parameters, ParameterType.PRICE_FROM);
            if (priceFrom != null) {
                uriComponentsBuilder.queryParam("search%5Bfilter_float_price%3Afrom%5D", priceFrom);
            }

            String priceTo = getParameterValue(parameters, ParameterType.PRICE_TO);
            if (priceFrom != null) {
                uriComponentsBuilder.queryParam("search%5Bfilter_float_price%3Ato%5D", priceTo);
            }
        }

        return uriComponentsBuilder.buildAndExpand(getKeyword(search)).toUriString();
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
