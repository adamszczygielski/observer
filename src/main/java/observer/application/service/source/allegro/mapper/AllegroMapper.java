package observer.application.service.source.allegro.mapper;

import observer.application.api.allegro.AllegroCategoryDto;
import observer.application.domain.Item;
import observer.application.service.source.allegro.model.*;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

import static observer.application.common.Utils.now;

@Component
public class AllegroMapper {

    public List<Item> toItems(List<ListingOffer> listingOffers, Long searchId) {
        return listingOffers.stream().map(listingOffer -> toItem(listingOffer, searchId))
                .collect(Collectors.toList());
    }

    public List<AllegroCategoryDto> toAllegroCategories(List<CategoryDto> categories) {
        return categories.stream().map(categoryDto ->
                AllegroCategoryDto.builder()
                        .id(categoryDto.getId())
                        .name(categoryDto.getName())
                        .leaf(categoryDto.getLeaf())
                        .build()).collect(Collectors.toList());
    }

    private Item toItem(ListingOffer listingOffer, Long searchId) {
        return Item.builder()
                .originId(listingOffer.getId())
                .searchId(searchId)
                .dateCreated(now())
                .title(listingOffer.getName())
                .price(toPrice(listingOffer.getSellingMode()))
                .url(toUrl(listingOffer))
                .isActive(true)
                .isNotified(false)
                .build();
    }

    private String toPrice(OfferSellingMode offerSellingMode) {
        OfferPrice offerPrice = offerSellingMode.getPrice();
        return offerPrice.getAmount() + " " + offerPrice.getCurrency();
    }

    private String toUrl(ListingOffer listingOffer) {
        if (listingOffer.getVendor() != null) {
            return listingOffer.getVendor().getUrl();
        } else {
            return UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host("allegro.pl")
                    .path("i{id}.html")
                    .buildAndExpand(listingOffer.getId())
                    .toUriString();
        }
    }
}
