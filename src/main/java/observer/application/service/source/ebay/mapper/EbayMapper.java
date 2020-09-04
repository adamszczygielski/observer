package observer.application.service.source.ebay.mapper;

import observer.application.domain.Item;
import observer.application.service.source.ebay.model.Amount;
import observer.application.service.source.ebay.model.SearchItem;
import observer.application.service.source.ebay.model.SellingStatus;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import static observer.application.common.Utils.now;

@Component
public class EbayMapper {

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public List<Item> toItems(List<SearchItem> searchItemList, Long searchId) {
        return searchItemList.stream().map(searchItem -> toItem(searchItem, searchId))
                .collect(Collectors.toList());
    }

    private Item toItem(SearchItem searchItem, Long searchId) {
        return Item.builder()
                .originId(searchItem.getItemId())
                .searchId(searchId)
                .dateCreated(now())
                .title(searchItem.getTitle())
                .price(toPrice(searchItem.getSellingStatus()))
                .url(searchItem.getViewItemURL())
                .isActive(true)
                .build();
    }

    private String toPrice(SellingStatus sellingStatus) {
        Amount amount = sellingStatus.getCurrentPrice();
        return decimalFormat.format(amount.getValue()) + " " + amount.getCurrencyId();
    }
}
