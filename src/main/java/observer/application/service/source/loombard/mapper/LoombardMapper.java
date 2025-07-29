package observer.application.service.source.loombard.mapper;

import observer.application.dto.Source;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.service.source.loombard.model.LoombardItem;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class LoombardMapper {

    public List<Item> toItems(List<LoombardItem> loombardItems, Search search) {
        return loombardItems.stream()
                .map(i -> toItem(i, search))
               .toList();
    }

    private Item toItem(LoombardItem loombardItem, Search search) {
        return Item.builder()
                .originId(String.valueOf(loombardItem.getId()))
                .search(search)
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
