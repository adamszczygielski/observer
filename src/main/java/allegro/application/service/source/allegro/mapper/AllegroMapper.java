package allegro.application.service.source.allegro.mapper;

import allegro.application.api.allegro.AllegroCategoryDto;
import allegro.application.domain.Item;
import allegro.application.service.source.allegro.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static allegro.application.common.Utils.now;

@Component
public class AllegroMapper {

    public List<Item> toItems(ListingResponseOffers listingResponseOffers, Long searchId) {
        ArrayList<Item> items = new ArrayList<>();
        listingResponseOffers.getRegular().forEach(listingOffer -> {
            items.add(toItem(listingOffer, searchId));
        });
        return items;
    }

    private Item toItem(ListingOffer listingOffer, Long searchId) {
        Item item = new Item();
        item.setOriginId(listingOffer.getId());
        item.setSearchId(searchId);
        item.setDateCreated(now());
        item.setTitle(listingOffer.getName());
        item.setPrice(getPrice(listingOffer.getSellingMode()));
        item.setUrl(getUrl(listingOffer));
        item.setIsActive(true);
        return item;
    }

    private String getPrice(OfferSellingMode offerSellingMode) {
        OfferPrice offerPrice = offerSellingMode.getPrice();
        return offerPrice.getAmount() + " " + offerPrice.getCurrency();
    }

    private String getUrl(ListingOffer listingOffer) {
        if(listingOffer.getVendor() != null) {
            return listingOffer.getVendor().getUrl();
        } else {
            return "https://allegro.pl/i" + listingOffer.getId() + ".html";
        }
    }

    public List<AllegroCategoryDto> toAllegroCategories(List<CategoryDto> categories) {
        ArrayList<AllegroCategoryDto> allegroCategories = new ArrayList<>();

        categories.forEach(categoryDto -> {
            allegroCategories.add(
                    AllegroCategoryDto.builder()
                            .id(categoryDto.getId())
                            .name(categoryDto.getName())
                            .leaf(categoryDto.getLeaf())
                            .build());
        });

        return allegroCategories;
    }

}
