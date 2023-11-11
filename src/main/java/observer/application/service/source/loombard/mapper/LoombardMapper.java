package observer.application.service.source.loombard.mapper;

import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.service.source.loombard.model.LoombardItem;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoombardMapper {

    public List<Item> toItems(List<LoombardItem> loombardItems, Long searchId) {
        return loombardItems.stream()
                .map(i -> toItem(i, searchId))
                .collect(Collectors.toList());
    }

    public String toUrl(Search search) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("www.loombard.pl")
                .pathSegment("api", "categories");

        if (search.getCategoryId() != null) {
            uriComponentsBuilder.pathSegment(search.getCategoryId());
        }

        uriComponentsBuilder.queryParam("searchQuery", search.getKeyword().replaceAll(" ", "+"))
                .queryParam("sort", "-created_at");

        if (search.getPriceFrom() != null) {
            uriComponentsBuilder.queryParam("price[from]", search.getPriceFrom());
        }

        if (search.getPriceTo() != null) {
            uriComponentsBuilder.queryParam("price[to]", search.getPriceTo());
        }

        return uriComponentsBuilder.build()
                .encode()
                .toUri()
                .toString();
    }

    private Item toItem(LoombardItem loombardItem, Long searchId) {
        return Item.builder()
                .originId(String.valueOf(loombardItem.getId()))
                .searchId(searchId)
                .createdDate(Instant.now())
                .title(loombardItem.getName())
                .price(loombardItem.getPrice().getFormatted() + " PLN")
                .url("https://www.loombard.pl/products/" + loombardItem.getSlug())
                .isDeleted(false)
                .isNotificationSent(false)
                .sourceId(Source.LOOMBARD.getId())
                .build();
    }
}
