package observer.application.service.source.ebay.mapper;

import observer.application.model.Item;
import observer.application.dto.Source;
import observer.application.service.source.ebay.model.ConvertedCurrentPrice;
import observer.application.service.source.ebay.model.EbayItem;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class EbayMapper {

    public List<Item> toItems(List<EbayItem> ebayItems, Long searchId) {
        return ebayItems.stream().map(ebayItem -> toItem(ebayItem, searchId))
                .collect(Collectors.toList());
    }

    private Item toItem(EbayItem ebayItem, Long searchId) {
        return Item.builder()
                .originId(ebayItem.getItemId())
                .searchId(searchId)
                .createdDate(Instant.now())
                .title(ebayItem.getTitle())
                .price(toPrice(ebayItem.getSellingStatus().getConvertedCurrentPrice()))
                .url(ebayItem.getViewItemURL())
                .isDeleted(false)
                .isNotificationSent(false)
                .sourceId(Source.EBAY.getId())
                .build();
    }

    private String toPrice(ConvertedCurrentPrice convertedCurrentPrice) {
        return convertedCurrentPrice.getPrice() + " " + convertedCurrentPrice.getCurrencyId();
    }
}
