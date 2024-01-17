package observer.application.service.source.loombard.mapper;

import observer.application.model.Item;
import observer.application.dto.Source;
import observer.application.service.source.loombard.model.LoombardItem;
import org.springframework.stereotype.Component;

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
