package allegro.application.service.allegro.mapper;

import allegro.application.api.ItemDto;
import allegro.application.common.Utils;
import allegro.application.domain.Item;
import allegro.application.domain.Search;
import allegro.application.service.allegro.model.ListingOffer;
import allegro.application.service.allegro.model.ListingResponseOffers;
import allegro.application.service.allegro.model.OfferPrice;
import allegro.application.service.allegro.model.OfferSellingMode;
import org.springframework.stereotype.Component;

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
        item.setOriginId(listingOffer.getId());
        item.setSearchId(searchId);
        item.setCreationDate(new Timestamp(System.currentTimeMillis()));
        item.setTitle(listingOffer.getName());
        item.setPrice(getPrice(listingOffer.getSellingMode()));
        item.setUrl(Utils.itemIdToUrl(listingOffer.getId()));
        item.setIsActive(true);
        return item;
    }

    public List<ItemDto> toItemDto(ListingResponseOffers listingResponseOffers) {
        ArrayList<ItemDto> items = new ArrayList<>();
        listingResponseOffers.getRegular().forEach(listingOffer -> {
            items.add(toItemDto(listingOffer));
        });
        return items;
    }

    private ItemDto toItemDto(ListingOffer listingOffer) {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemId(-1L);
        itemDto.setOriginId(listingOffer.getId());
        itemDto.setTitle(listingOffer.getName());
        itemDto.setCreationDate(null);
        itemDto.setPrice(getPrice(listingOffer.getSellingMode()));
        itemDto.setUrl(Utils.itemIdToUrl(listingOffer.getId()));
        return itemDto;
    }

    private String getPrice(OfferSellingMode offerSellingMode) {
        OfferPrice offerPrice = offerSellingMode.getPrice();
        return offerPrice.getAmount() + " " + offerPrice.getCurrency();
    }
}
