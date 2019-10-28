package allegro.application.service.olx;

import allegro.application.api.ItemDto;
import allegro.application.common.ItemAssembler;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class OlxSerivce implements ItemService {

    private final Logger log = Logger.getLogger(getClass().getName());

    private ItemAssembler itemAssembler;

    @Override
    public List<Item> getItems(Search search) {
        return fetchItems(search);
    }

    @Override
    public List<ItemDto> getPreview(Search search) {
       List<ItemDto> itemDtos = itemAssembler.toDtoList(fetchItems(search));
       itemDtos.forEach(i -> i.setItemId(-1L));
       return itemDtos;
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
            log.log(Level.SEVERE, "---------- Parser error while trying to fetch: " + search.getKeyword());
            return items;
        }

        for(int i = 0; i < titles.size(); i++ ) {
            Item item = new Item();
            item.setOriginId(originIds.get(i).attr("data-id"));
            item.setSearchId(search.getId());
            item.setCreationDate(new Timestamp(System.currentTimeMillis()));
            item.setTitle(titles.get(i).text());
            item.setPrice(prices.get(i).text());
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
        return url.substring(0, url.indexOf("#"));
    }
}