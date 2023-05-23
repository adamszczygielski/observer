package observer.application.service.source.allegrolokalnie;

import observer.application.config.ApplicationConfig;
import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.service.source.DocumentService;
import observer.application.service.source.SourceService;
import observer.application.service.source.allegrolokalnie.mapper.AllegroLokalnieMapper;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AllegroLokalnieService extends SourceService {

    private final DocumentService documentService;
    private final AllegroLokalnieMapper allegroLokalnieMapper = new AllegroLokalnieMapper();

    public AllegroLokalnieService(ApplicationConfig applicationConfig, DocumentService documentService) {
        super(applicationConfig);
        this.documentService = documentService;
    }

    @Override
    public Source getSource() {
        return Source.ALLEGRO_LOKALNIE;
    }

    @Override
    public Duration getDelay() {
        return applicationConfig.getAllegroLokalnieDelay();
    }

    @Override
    public List<Item> fetchItems(Search search) {
        Document document = documentService.getDocument(allegroLokalnieMapper.toUrl(search));

        if (!document.title().toLowerCase().contains(search.getKeyword())) {
            throw new IllegalStateException("Bad request");
        }

        List<String> titles = document.getElementsByClass("mlc-itembox__title").stream()
                .map(e -> e.childNode(0).toString())
                .collect(Collectors.toList());

        List<String> prices = document.getElementsByClass("ml-offer-price__dollars").stream()
                .map(e -> e.childNode(0).toString().replace(" ", "") + " PLN")
                .collect(Collectors.toList());

        List<String> relativeUrls = document.getElementsByClass("mlc-card mlc-itembox").stream()
                .map(e -> e.attr("href"))
                .collect(Collectors.toList());

        List<String> urls = relativeUrls.stream()
                .map(e -> "https://allegrolokalnie.pl" + e)
                .collect(Collectors.toList());

        List<String> originIds = relativeUrls.stream()
                .map(e -> e.replace("/oferta/", ""))
                .collect(Collectors.toList());

        List<Item> items = new ArrayList<>(prices.size());

        for (int i = 0; i < prices.size(); i++) {
            items.add(Item.builder()
                    .originId(originIds.get(i))
                    .searchId(search.getId())
                    .createdDate(Instant.now())
                    .title(titles.get(i))
                    .price(prices.get(i))
                    .url(urls.get(i))
                    .isDeleted(false)
                    .isNotificationSent(false)
                    .sourceId(Source.ALLEGRO_LOKALNIE.getId())
                    .build());
        }
        return items;
    }

    @Override
    public List<Category> fetchCategories(String parentId) {
        return Collections.emptyList();
    }
}
