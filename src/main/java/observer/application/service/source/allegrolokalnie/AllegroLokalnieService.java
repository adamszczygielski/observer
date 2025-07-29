package observer.application.service.source.allegrolokalnie;

import lombok.RequiredArgsConstructor;
import observer.application.config.ApplicationConfig;
import observer.application.dto.Source;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.service.DocumentService;
import observer.application.service.source.SourceService;
import observer.application.service.source.allegrolokalnie.mapper.AllegroLokalnieMapper;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AllegroLokalnieService implements SourceService {

    private final ApplicationConfig applicationConfig;
    private final DocumentService documentService;
    private final AllegroLokalnieMapper allegroLokalnieMapper = new AllegroLokalnieMapper();

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
        Document document = documentService.getDocumentByJsoup(search.getParams());
        if (document.body().getElementsByClass("mlc-no-offers-to-show").first() != null) {
            return List.of();
        }

        List<String> titles = document.getElementsByClass("mlc-itembox__title").stream()
                .map(e -> e.childNode(0).toString())
                .toList();

        List<String> prices = document.getElementsByClass("ml-offer-price__dollars").stream()
                .map(e -> e.childNode(0).toString().replace(" ", "") + " PLN")
               .toList();

        List<String> urls = document.getElementsByClass("mlc-card mlc-itembox").stream()
                .map(e -> e.attr("href"))
                .map(s -> s.contains("allegro.pl") ? s : "https://allegrolokalnie.pl" + s)
               .toList();

        List<String> originIds = document.getElementsByClass("mlc-card mlc-itembox").stream()
                .map(e -> e.attr("data-card-analytics-click"))
               .toList();

        return allegroLokalnieMapper.toItems(originIds, titles, prices, urls, search);
    }
}
