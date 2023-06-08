package observer.application.service.source.allegrolokalnie.mapper;

import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllegroLokalnieMapper {

    public String toUrl(Search search) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("allegrolokalnie.pl")
                .pathSegment("oferty");

        if (search.getCategoryId() != null) {
            uriComponentsBuilder.path(search.getCategoryId());
        }

        uriComponentsBuilder.pathSegment("q")
                .path(search.getKeyword());

        if (search.getPriceFrom() != null) {
            uriComponentsBuilder.queryParam("price_from", search.getPriceFrom());
        }

        if (search.getPriceTo() != null) {
            uriComponentsBuilder.queryParam("price_to", search.getPriceTo());
        }

        return uriComponentsBuilder.queryParam("dont_suggest_phrase", "true")
                .build()
                .toUri()
                .toString();
    }

    public List<Item> toItems(List<String> originIds, List<String> titles, List<String> prices, List<String> urls,
                              Long searchId) {
        return IntStream.range(0, prices.size()).mapToObj(i ->
                Item.builder()
                        .originId(originIds.get(i))
                        .searchId(searchId)
                        .createdDate(Instant.now())
                        .title(titles.get(i))
                        .price(prices.get(i))
                        .url(urls.get(i))
                        .isDeleted(false)
                        .isNotificationSent(false)
                        .sourceId(Source.ALLEGRO_LOKALNIE.getId())
                        .build()).collect(Collectors.toList());
    }
}
