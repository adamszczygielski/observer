package allegro.application.service.source.ebay.mapper;

import allegro.application.domain.Item;
import allegro.application.domain.Search;
import allegro.application.service.source.ebay.model.Amount;
import allegro.application.service.source.ebay.model.SearchItem;
import allegro.application.service.source.ebay.model.SellingStatus;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class EbayMapper {

    private final DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public List<Item> toItem(List<SearchItem> searchItemList, Search search) {
        ArrayList<Item> items = new ArrayList<>();
        searchItemList.forEach(searchItem -> {
            items.add(toItem(searchItem, search.getId()));
        });
        return items;
    }

    private Item toItem(SearchItem searchItem, Long searchId) {
        Item item = new Item();
        item.setOriginId(searchItem.getItemId());
        item.setSearchId(searchId);
        item.setDateCreated(new Timestamp(System.currentTimeMillis()));
        item.setTitle(searchItem.getTitle());
        item.setPrice(getPrice(searchItem.getSellingStatus()));
        item.setUrl(searchItem.getViewItemURL());
        item.setIsActive(true);
        return item;
    }

    private String getPrice(SellingStatus sellingStatus) {
        Amount amount = sellingStatus.getCurrentPrice();
        return  decimalFormat.format(amount.getValue()) + " " + amount.getCurrencyId();
    }
}
