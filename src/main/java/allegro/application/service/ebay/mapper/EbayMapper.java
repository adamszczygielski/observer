package allegro.application.service.ebay.mapper;

import allegro.application.api.ItemDto;
import allegro.application.domain.Item;
import allegro.application.domain.Search;
import allegro.application.service.ebay.model.Amount;
import allegro.application.service.ebay.model.SearchItem;
import allegro.application.service.ebay.model.SellingStatus;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class EbayMapper {

    private final DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public List<ItemDto> toItemDto(List<SearchItem> searchItemList) {
        ArrayList<ItemDto> items = new ArrayList<>();
        searchItemList.forEach(searchItem -> {
            items.add(toItemDto(searchItem));
        });
        return items;
    }

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
        item.setCreationDate(new Timestamp(System.currentTimeMillis()));
        item.setTitle(searchItem.getTitle());
        item.setPrice(getPrice(searchItem.getSellingStatus()));
        item.setUrl(searchItem.getViewItemURL());
        item.setIsActive(true);
        return item;
    }

    private ItemDto toItemDto(SearchItem searchItem) {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemId(-1L);
        itemDto.setOriginId(searchItem.getItemId());
        itemDto.setTitle(searchItem.getTitle());
        itemDto.setCreationDate(null);
        itemDto.setPrice(getPrice(searchItem.getSellingStatus()));
        itemDto.setUrl(searchItem.getViewItemURL());
        return itemDto;
    }

    private String getPrice(SellingStatus sellingStatus) {
        Amount amount = sellingStatus.getCurrentPrice();
        return  decimalFormat.format(amount.getValue()) + " " + amount.getCurrencyId();
    }
}
