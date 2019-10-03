package allegro.application.mapper;

import allegro.application.api.ItemDto;
import allegro.application.entity.Item;
import allegro.application.entity.Search;
import allegro.application.model.ListingOffer;
import allegro.application.model.ListingResponseOffers;
import allegro.application.model.OfferPrice;
import allegro.application.model.OfferSellingMode;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class AllegroMapper {
    public List<Item> toItem(ListingResponseOffers listingResponseOffers, Search search) {
        ArrayList<Item> items = new ArrayList<>();
        listingResponseOffers.getRegular().forEach(listingOffer -> {
            items.add(toItem(listingOffer, search.getId()));
        });
        return items;
    }

    private Item toItem(ListingOffer listingOffer, Long searchId) {
        Item item = new Item();
        item.setItemId(Long.valueOf(listingOffer.getId()));
        item.setSearchId(searchId);
        item.setCreationDate(new Timestamp(System.currentTimeMillis()));
        item.setTitle(listingOffer.getName());
        item.setPrice(getPrice(listingOffer.getSellingMode()));
        item.setIsActive(true);
        return item;
    }

    public List<ItemDto> toItemDto(ListingResponseOffers listingResponseOffers, Search search) {
        ArrayList<ItemDto> items = new ArrayList<>();
        listingResponseOffers.getRegular().forEach(listingOffer -> {
            items.add(toItemDto(listingOffer));
        });
        return items;
    }

    private ItemDto toItemDto(ListingOffer listingOffer) {
        ItemDto itemDto = new ItemDto();
        Long itemId = Long.parseLong(listingOffer.getId());
        itemDto.setItemId(itemId);
        itemDto.setTitle(listingOffer.getName());
        itemDto.setCreationDate(null);
        itemDto.setPrice(getPrice(listingOffer.getSellingMode()));
        itemDto.setUrl(getUrl(itemId));
        return itemDto;
    }

    private String getUrl(Long itemId) {
        if(StringUtils.isEmpty(itemId)) {
            return "";
        }
        return "https://allegro.pl/i" + itemId + ".html";
    }

    private String getPrice(OfferSellingMode offerSellingMode) {
        OfferPrice offerPrice = offerSellingMode.getPrice();
        return offerPrice.getAmount() + " " + offerPrice.getCurrency();
    }
}
