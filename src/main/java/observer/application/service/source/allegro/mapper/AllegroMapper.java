package observer.application.service.source.allegro.mapper;

import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.service.RandomUtils;
import observer.application.service.source.allegro.model.category.CategoryDto;
import observer.application.service.source.allegro.model.listing.Element;
import observer.application.service.source.allegro.model.listing.Price;
import org.springframework.lang.Nullable;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;

public class AllegroMapper {

    public String toUrl(Search search) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("allegro.pl");

        if (search.getCategoryId() != null) {
            uriComponentsBuilder.pathSegment("kategoria");
            uriComponentsBuilder.path(search.getCategoryId());
        } else {
            uriComponentsBuilder.path("listing");
        }

        return uriComponentsBuilder.queryParam("price_from", randomizePriceFrom(search.getPriceFrom()))
                .queryParam("price_to", randomizePriceTo(search.getPriceTo()))
                .queryParam("string", RandomUtils.randomizeCase(search.getKeyword()))
                .queryParam("fallback", "dym")
                .queryParam("strategy", "NO_FALLBACK")
                .queryParam("ref", "dym-redirect")
                .build()
                .toUri()
                .toString();
    }

    public Category toCategory(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .leaf(categoryDto.getLeaf())
                .build();
    }

    public Item toItem(Element element, Long searchId) {
        return Item.builder()
                .originId(element.getId())
                .searchId(searchId)
                .createdDate(Instant.now())
                .title(element.getTitle().getText())
                .price(toPrice(element.getPrice()))
                .url(toUrl(element))
                .isDeleted(false)
                .isNotificationSent(false)
                .sourceId(Source.ALLEGRO.getId())
                .build();
    }

    private String toPrice(Price price) {
        return String.join(" ", price.getMain().getAmount(), price.getMain().getCurrency());
    }

    private String toUrl(Element element) {
        String url = element.getUrl();
        if (url.length() > 255) {
            return toUrl(element.getId());
        }
        return url;
    }

    private String toUrl(String elementId) {
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("allegro.pl")
                .path("i{id}.html")
                .buildAndExpand(elementId)
                .toUriString();
    }

    private double randomizePriceFrom(@Nullable Integer priceFrom) {
        return priceFrom == null ?
                RandomUtils.getInt(0, 99) / 100d :
                priceFrom + RandomUtils.getInt(0, 99) / 100d;
    }

    private double randomizePriceTo(@Nullable Integer priceTo) {
        return priceTo == null ?
                RandomUtils.getInt(100_000_000, 200_000_000) / 100d :
                priceTo + RandomUtils.getInt(0, 99) / 100d;
    }
}
