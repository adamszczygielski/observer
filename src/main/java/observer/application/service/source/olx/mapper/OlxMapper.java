package observer.application.service.source.olx.mapper;

import observer.application.model.Item;
import observer.application.dto.Source;
import observer.application.model.Search;
import observer.application.service.source.olx.model.Ad;
import observer.application.service.source.olx.model.Price;

import java.time.Instant;
import java.util.Optional;

public class OlxMapper {

    public Item toItem(Ad ad, Search search) {
        return Item.builder()
                .originId(ad.getId())
                .search(search)
                .createdDate(Instant.now())
                .title(ad.getTitle())
                .price(toPrice(ad.getPrice()))
                .url(ad.getUrl())
                .isDeleted(false)
                .isNotificationSent(false)
                .sourceId(Source.OLX.getId())
                .build();
    }

    private String toPrice(Price price) {
        return Optional.ofNullable(price)
                .map(Price::getRegularPrice)
                .map(p -> p.getValue() + " " + p.getCurrencyCode())
                .orElse("0.00 PLN");
    }
}
