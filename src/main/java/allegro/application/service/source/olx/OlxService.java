package allegro.application.service.source.olx;

import allegro.application.domain.Item;
import allegro.application.domain.Search;
import allegro.application.service.ItemService;
import lombok.AllArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static allegro.application.common.Utils.now;

@Service
@AllArgsConstructor
public class OlxService implements ItemService {

    private final Logger log = Logger.getLogger(getClass().getName());

    @Override
    public List<Item> getItems(Search search) {
        return fetchItems(search);
    }

    private List<Item> fetchItems(Search search) {
        ArrayList<Item> items = new ArrayList<>();
        Connection connection = Jsoup.connect(getRequestUrl(search.getKeyword()));
        Document document = null;
        try {
            document = connection.get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements noItemsInfo = document.select("p > span");
        if(noItemsInfo.get(0).text().equals("Sprawdź poprawność albo spróbuj bardziej ogólnego zapytania")) {
            return items;
        }

        Elements titles = document.select("h3 > a");
        Elements prices = document.select("td > div > p > strong");
        Elements urls = document.select("h3 > a[href]");
        Elements originIds = document.select("td > div > table");

        int quantity = titles.size();
        if(prices.size() != quantity || urls.size() != quantity || originIds.size() != quantity) {
            log.log(Level.SEVERE, "Parser error while trying to fetch: " + search.getKeyword());
            return items;
        }

        for(int i = 0; i < titles.size(); i++ ) {
            Item item = new Item();
            item.setOriginId(originIds.get(i).attr("data-id"));
            item.setSearchId(search.getId());
            item.setDateCreated(now());
            item.setTitle(titles.get(i).text());
            item.setPrice(getPrice(prices.get(i).text()));
            item.setUrl(getItemUrl(urls.get(i)));
            item.setIsActive(true);
            items.add(item);
        }

        return items;
    }

    private String getRequestUrl(String keyword) {
        return "https://www.olx.pl/oferty/q-"
                + keyword.replaceAll(" ", "-")
                + "/?search%5Border%5D=created_at%3Adesc&spellchecker=off";
    }

    private String getItemUrl(Element element) {
        String url = element.attr("href");
        int endIndex = url.indexOf("#");
        if(endIndex > 0) {
            return url.substring(0, endIndex);
        }
        return url;
    }

    private String getPrice(String price) {
        return price.replace(" ", "").replace("zł", ".00 PLN");
    }
}
