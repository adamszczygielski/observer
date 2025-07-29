package observer.application.service.source.ebay.mapper;

import observer.application.dto.Source;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.service.source.ebay.model.ConvertedCurrentPrice;
import observer.application.service.source.ebay.model.EbayItem;

import java.time.Instant;
import java.util.List;

public class EbayMapper {

    public List<Item> toItems(List<EbayItem> ebayItems, Search search) {
        return ebayItems.stream().map(ebayItem -> toItem(ebayItem, search))
               .toList();
    }

    private Item toItem(EbayItem ebayItem, Search search) {
        return Item.builder()
                .originId(ebayItem.getItemId())
                .search(search)
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
