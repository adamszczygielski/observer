package observer.application.service.source.allegrolokalnie.mapper;

import observer.application.model.Item;
import observer.application.dto.Source;
import observer.application.model.Search;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllegroLokalnieMapper {

    public List<Item> toItems(List<String> originIds, List<String> titles, List<String> prices, List<String> urls,
                              Search search) {
        return IntStream.range(0, prices.size()).mapToObj(i ->
                Item.builder()
                        .originId(originIds.get(i))
                        .search(search)
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
