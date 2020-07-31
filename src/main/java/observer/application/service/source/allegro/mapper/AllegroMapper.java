package observer.application.service.source.allegro.mapper;

import observer.application.api.allegro.AllegroCategoryDto;
import observer.application.domain.Item;
import observer.application.service.source.allegro.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static observer.application.common.Utils.now;

@Component
public class AllegroMapper {

    public List<Item> toItems(ListingResponseOffers listingResponseOffers, Long searchId) {
        return listingResponseOffers.getRegular().stream().map(listingOffer -> toItem(listingOffer, searchId))
                .collect(Collectors.toList());
    }

    public List<AllegroCategoryDto> toAllegroCategories(List<CategoryDto> categories) {
        return categories.stream().map(categoryDto -> AllegroCategoryDto.builder().id(categoryDto.getId())
                .name(categoryDto.getName()).leaf(categoryDto.getLeaf()).build()).collect(Collectors.toList());
    }

    private Item toItem(ListingOffer listingOffer, Long searchId) {
        return Item.builder()
                .originId(listingOffer.getId())
                .searchId(searchId)
                .dateCreated(now())
                .title(listingOffer.getName())
                .price(getPrice(listingOffer.getSellingMode()))
                .url(getUrl(listingOffer))
                .isActive(true)
                .build();
    }

    private String getPrice(OfferSellingMode offerSellingMode) {
        OfferPrice offerPrice = offerSellingMode.getPrice();
        return offerPrice.getAmount() + " " + offerPrice.getCurrency();
    }

    private String getUrl(ListingOffer listingOffer) {
        if (listingOffer.getVendor() != null) {
            return listingOffer.getVendor().getUrl();
        } else {
            return "https://allegro.pl/i" + listingOffer.getId() + ".html";
        }
    }
}
